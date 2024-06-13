package pl.pjatk.mas.s24512.masproject.Database;

import pl.pjatk.mas.s24512.masproject.Models.*;
import pl.pjatk.mas.s24512.masproject.Models.enums.AccountantType;
import pl.pjatk.mas.s24512.masproject.Models.enums.TeamType;
import pl.pjatk.mas.s24512.masproject.Util;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Save {

    public static void saveCommunicationPlanners(){
        try{
            Class.forName(Utils.DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;
        Connection connection = null;

        try {
            for(CommunicationPlanner cp : Util.communicationPlanners){
                saveEmployee(cp);
                if(!idExistsInTable(cp.getId(), Utils.COMMUNICATION_PLANNER_TABLE)) insertSubordinateIntoTable(cp.getId(), cp.getManagerId(), Utils.COMMUNICATION_PLANNER_TABLE);
                if(idExistsInTable(cp.getId(), Utils.COMMUNICATION_PLANNER_MANAGER_TABLE)) removeRecordFromTableById(cp.getId(), Utils.COMMUNICATION_PLANNER_MANAGER_TABLE);

                connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
                String sql = "UPDATE " + Utils.COMMUNICATION_PLANNER_TABLE +
                        " SET managerId = ? " +
                        "WHERE id = ?";
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, cp.getManagerId());
                pstmt.setString(2, cp.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void saveTraffics(){
        try{
            Class.forName(Utils.DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;
        Connection connection = null;

        try {
            for(Traffic traffic : Util.traffics){
                saveEmployee(traffic);

                connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
                String sql = "UPDATE " + Utils.TRAFFIC_TABLE +
                        " SET managerId = ? " +
                        "WHERE id = ?";
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, traffic.getManagerId());
                pstmt.setString(2, traffic.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void saveAccountants(){
        for(Accountant accountant : Util.accountants){
            // saving Employee changes
            saveEmployee(accountant);
            // checking if accountant is AIO and if exists in AIO table
            if (accountant.getType().contains(AccountantType.ACCOUNTANT_CAMPAIGN) && accountant.getType().contains(AccountantType.ACCOUNTANT_COMPANY)){
                // inserting if not exist already
                if(!idExistsInTable(accountant.getId(), Utils.ACCOUNTANT_AIO_TABLE)) insertAndRemoveAccountant(accountant.getId(), Utils.ACCOUNTANT_AIO_TABLE, Arrays.asList(Utils.CAMPAIGN_ACCOUNTANT_TABLE, Utils.COMPANY_ACCOUNTANT_TABLE));
            }
            // checking if accountant is Campaign and if exists in Campaign table
            else if (accountant.getType().contains(AccountantType.ACCOUNTANT_CAMPAIGN)) {
                // inserting if not exist already
                if (!idExistsInTable(accountant.getId(), Utils.CAMPAIGN_ACCOUNTANT_TABLE)) insertAndRemoveAccountant(accountant.getId(), Utils.CAMPAIGN_ACCOUNTANT_TABLE, Arrays.asList(Utils.ACCOUNTANT_AIO_TABLE, Utils.COMPANY_ACCOUNTANT_TABLE));
            }
            // checking if accountant is Company and if exists in Company table
            else if (accountant.getType().contains(AccountantType.ACCOUNTANT_COMPANY)) {
                // inseting if not  exist already
                if(!idExistsInTable(accountant.getId(), Utils.COMPANY_ACCOUNTANT_TABLE)) insertAndRemoveAccountant(accountant.getId(), Utils.COMPANY_ACCOUNTANT_TABLE, Arrays.asList(Utils.ACCOUNTANT_AIO_TABLE, Utils.CAMPAIGN_ACCOUNTANT_TABLE));
            }
        }
    }
    public static void saveCommunicationPlannerManagers(){
        for(CommunicationPlannerManager cpm : Util.communicationPlannerManagers){
            saveEmployee(cpm);
            if(!idExistsInTable(cpm.getId(), Utils.COMMUNICATION_PLANNER_MANAGER_TABLE)) insertIdIntoTable(cpm.getId(), Utils.COMMUNICATION_PLANNER_MANAGER_TABLE);
            if(idExistsInTable(cpm.getId(), Utils.COMMUNICATION_PLANNER_TABLE)) removeRecordFromTableById(cpm.getId(), Utils.COMMUNICATION_PLANNER_TABLE);

        }
    }
    public static void saveAnnualBonuses(){
        saveAnnualBonusForPlanners();
        saveAnnualBonusForTraffics();
    }
    public static void saveCampaigns(){
        for(Campaign c : Util.campaigns){
            if (idExistsInTable(c.getId(), Utils.CAMPAIGN_TABLE)) updateCampaign(c);
            else insertCampaign(c);
        }
    }
    public static void savePlans(){
        for(Plan plan : Util.plans){
            if (idExistsInTable(plan.getId(), Utils.CAMPAIGN_PLAN_TABLE)) updatePlan(plan);
            else insertPlan(plan);
        }
    }
    public static void saveClients(){
        for(Client c : Util.clients){
            if(!idExistsInTable(c.getId(), Utils.CLIENT_TABLE)) insertClient(c);
        }
    }
    public static void saveCompanies(){
        for(Company c: Util.companies){
            if(!idExistsInTable(c.getId(), Utils.COMPANY_TABLE)) insertCompany(c);
        }
    }
    public static void saveDesigners(){
        for(Designer d: Util.designers){
            saveEmployee(d);
        }
    }
    public static void saveTrafficsAIO(){
        for(TrafficAIO t: Util.trafficsAIO){
            saveEmployee(t);
        }
    }    public static void saveTrafficManagers(){
        for(TrafficManager t: Util.trafficManagers){
            saveEmployee(t);
        }
    }
    // =================================================================================================================
    private static void insertClient(Client c) {
        Connection connection = null;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO "+ Utils.CLIENT_TABLE + " (id, firstName, lastName, emailAddress, phoneNumber, companyId) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, c.getId());
            pstmt.setString(2, c.getFirstName());
            pstmt.setString(3, c.getLastName());
            pstmt.setString(4, c.getEmail());
            pstmt.setString(5, c.getPhoneNumber());
            pstmt.setString(6, c.getCompanyId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void insertPlan(Plan plan) {
        Connection connection = null;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO "+ Utils.CAMPAIGN_PLAN_TABLE + " (id, estimatedRate, target, communicationChannel) " +
                    "VALUES (?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, plan.getId());
            pstmt.setInt(2, plan.getEstimatedRate());
            pstmt.setString(3, plan.getTarget());
            pstmt.setString(4, String.valueOf(plan.getCommunicationChannel()));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void insertCompany(Company company) {
        Connection connection = null;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO "+ Utils.COMPANY_TABLE + " (id, name, address, accountNumber, isRegular) " +
                    "VALUES (?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, company.getId());
            pstmt.setString(2, company.getName());
            pstmt.setString(3, company.getAdress());
            pstmt.setString(4, company.getAccountNumber());
            pstmt.setString(5, String.valueOf(company.isRegular()));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void updatePlan(Plan plan) {
        Connection connection = null;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "Update " + Utils.CAMPAIGN_PLAN_TABLE +
                    " SET estimatedRate = ?, target = ?, communicationChannel = ?" +
                    " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, plan.getEstimatedRate());
            pstmt.setString(2, plan.getTarget());
            pstmt.setString(3, String.valueOf(plan.getCommunicationChannel()));
            pstmt.setString(4, plan.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void updateCampaign(Campaign campaign){
        Connection connection = null;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "Update " + Utils.CAMPAIGN_TABLE +
                    " SET startDate = ?, endDate = ?, currentRate = ?, needsNewCreation = ?, size = ?, isAnimated = ?, creationDescription = ?, status = ?, " +
                    "settlement = ?, plannerId = ?, trafficId = ?, planId = ?, designerId = ?, accountantId = ?, description = ?" +
                    " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setDate(1, campaign.getStartDate());
            pstmt.setDate(2, campaign.getEndDate());
            pstmt.setInt(3, campaign.getCurrentRate());
            pstmt.setString(4, String.valueOf(campaign.isNeedsNewCreation()));
            pstmt.setString(5, String.valueOf(campaign.getSize()));
            pstmt.setString(6, String.valueOf(campaign.isAnimated()));
            pstmt.setString(7, campaign.getCreationDesc());
            pstmt.setString(8, String.valueOf(campaign.getStatus()));
            pstmt.setString(9, String.valueOf(campaign.getSettlement()));
            pstmt.setString(10, campaign.getPlannerId());
            pstmt.setString(11, campaign.getTrafficId());
            pstmt.setString(12, campaign.getPlanId());
            pstmt.setString(13, campaign.getDesignerId());
            pstmt.setString(14, campaign.getAccountantId());
            pstmt.setString(15, campaign.getDescription());
            pstmt.setString(16, campaign.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void insertCampaign(Campaign campaign){
        Connection connection = null;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO Campaign (id, name, startDate, endDate, currentRate, needsNewCreation, size, isAnimated, creationDescription , status, settlement, plannerId, trafficId, clientId, planId, designerId, accountantId, description) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, campaign.getId());
            pstmt.setString(2, campaign.getName());
            pstmt.setDate(3, campaign.getStartDate());
            pstmt.setDate(4, campaign.getEndDate());
            pstmt.setInt(5, campaign.getCurrentRate());
            pstmt.setBoolean(6, campaign.isNeedsNewCreation());
            pstmt.setString(7, String.valueOf(campaign.getSize()));
            pstmt.setBoolean(8, campaign.isAnimated());
            pstmt.setString(9, campaign.getCreationDesc());
            pstmt.setString(10, String.valueOf(campaign.getStatus()));
            pstmt.setString(11, String.valueOf(campaign.getSettlement()));
            pstmt.setString(12, campaign.getPlannerId());
            pstmt.setString(13, campaign.getTrafficId());
            pstmt.setString(14, campaign.getClientId());
            pstmt.setString(15, campaign.getPlanId());
            pstmt.setString(16, campaign.getDesignerId());
            pstmt.setString(17, campaign.getAccountantId());
            pstmt.setString(18, campaign.getDescription());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void saveAnnualBonusForPlanners(){
        Connection connection = null;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "Update " + Utils.ANNUAL_BONUS_TABLE+ " SET bonus = ? WHERE team = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, CommunicationPlannerManager.getAnnualBonus());
            pstmt.setString(2, String.valueOf(TeamType.PLANNERS));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void saveAnnualBonusForTraffics(){
        Connection connection = null;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "Update " + Utils.ANNUAL_BONUS_TABLE+ " SET bonus = ? WHERE team = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, TrafficManager.getAnnualBonus());
            pstmt.setString(2, String.valueOf(TeamType.TRAFFICS));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void insertAndRemoveAccountant(String accountantId, String insertTable, List<String> removeTables){
        insertIdIntoTable(accountantId, insertTable);
        for(String table : removeTables) removeRecordFromTableById(accountantId, table);
    }
    private static void insertIdIntoTable(String id, String table){
        Connection connection = null;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO " + table + " (id) VALUES (?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void insertSubordinateIntoTable(String plannerId, String managerId, String table){
        Connection connection = null;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO " + table + " (id, managerId) VALUES (?, ?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, plannerId);
            pstmt.setString(2, managerId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void removeRecordFromTableById(String id, String table){
        //checking if id exist in table
        if(!idExistsInTable(id, table)) return;
        Connection connection = null;

        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "DELETE FROM " + table + " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void saveEmployee(Employee employee){
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "UPDATE " + Utils.EMPLOYEE_TABLE +
                    " SET " +
                    "firstName = ?, " +
                    "lastname = ?, " +
                    "login = ?, " +
                    "password = ?, " +
                    "salary = ?, " +
                    "levelOfEducation = ? " +
                    "WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setString(3, employee.getLogin());
            pstmt.setString(4, employee.getPassword());
            pstmt.setString(5, String.valueOf(employee.getSalary()));
            pstmt.setString(6, String.valueOf(employee.getEducationLevel().getEducationType()));
            pstmt.setString(7, employee.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static boolean idExistsInTable(String id, String tableName){
        Connection connection = null;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if(res.next()) return res.getInt(1) > 0;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
