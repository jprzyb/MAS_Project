package pl.pjatk.mas.s24512.masproject.Database;

import pl.pjatk.mas.s24512.masproject.Models.*;
import pl.pjatk.mas.s24512.masproject.Models.enums.*;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Load {

    public static List<CommunicationPlanner> loadCommunicationPlanners(){
        List<CommunicationPlanner> result = new ArrayList<>();
        List<String> ids = readIds(Utils.COMMUNICATION_PLANNER_TABLE);
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                result.add(new CommunicationPlanner(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu),getCampaignsIdsByPlannerId(id), getPlannerManagerIdByPlannerId(id)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static List<CommunicationPlannerManager> loadCommunicationPlannerManagers(){
        List<CommunicationPlannerManager> result = new ArrayList<>();

        List<String> ids = readIds(Utils.COMMUNICATION_PLANNER_MANAGER_TABLE);
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                result.add(new CommunicationPlannerManager(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu),getCampaignsIdsByPlannerId(id), getSubordinatesIdByManagerId(id, Utils.COMMUNICATION_PLANNER_TABLE)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;

    }
    public static List<Traffic> loadTraffics(){
        List<Traffic> result = new ArrayList<>();

        List<String> ids = readIds(Utils.TRAFFIC_TABLE);
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                result.add(new Traffic(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu),getCampaignsIdsByTrafficId(id), getTrafficManagerIdByTrafficId(id)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static List<TrafficManager> loadTrafficManagers(){
        List<TrafficManager> result = new ArrayList<>();

        List<String> ids = readIds(Utils.TRAFFIC_MANAGER_TABLE);
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                result.add(new TrafficManager(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu), getSubordinatesIdByManagerId(id, Utils.TRAFFIC_TABLE)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static List<TrafficAIO> loadTrafficsAIO(){
        List<TrafficAIO> result = new ArrayList<>();

        List<String> ids = readIds(Utils.TRAFFIC_AIO_TABLE);
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                result.add(new TrafficAIO(id, firstName,lastName, login, password, birthDate, employmentDate, salary,
                        new EducationLevel(edu), getSubordinatesIdByManagerId(id, Utils.TRAFFIC_TABLE), getCampaignsIdsByTrafficId(id)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static List<Designer> loadDesigners(){
        List<Designer> result = new ArrayList<>();

        List<String> ids = readIds(Utils.DESIGNER_TABLE);
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                result.add(new Designer(id, firstName,lastName, login, password, birthDate, employmentDate, salary,
                        new EducationLevel(edu), getCampaignsIdsByDesignerId(id)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static List<Accountant> loadAccountants(){
        List<Accountant> result = new ArrayList<>();

        List<String> ids = new ArrayList<>();

        for(String id : readIds(Utils.ACCOUNTANT_AIO_TABLE)){
            if(!ids.contains(id)) ids.add(id);
        }
        for(String id : readIds(Utils.CAMPAIGN_ACCOUNTANT_TABLE)){
            if(!ids.contains(id)) ids.add(id);
        }
        for(String id : readIds(Utils.COMPANY_ACCOUNTANT_TABLE)){
            if(!ids.contains(id)) ids.add(id);
        }

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EMPLOYEE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                assert ids != null;
                if(!ids.contains(id)) continue;
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                double salary = res.getDouble("salary");
                String edu = res.getString("levelOfEducation");

                if(isAccountantAIO(id)) {
                    result.add(new Accountant(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu), EnumSet.allOf(AccountantType.class)));
                }
                else if(isAccountantCampaign(id)) {
                    result.add(new Accountant(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu), EnumSet.of(AccountantType.ACCOUNTANT_CAMPAIGN)));
                }
                else if(isAccountantCompany(id)) {
                    result.add(new Accountant(id, firstName,lastName, login, password, birthDate, employmentDate, salary, new EducationLevel(edu), EnumSet.of(AccountantType.ACCOUNTANT_COMPANY)));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static List<Client> loadClients(){
        List<Client> result = new ArrayList<>();
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CLIENT_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String emailAdress = res.getString("emailAddress");
                String phoneNumber = res.getString("phoneNumber");
                String companyId = res.getString("companyId");
                result.add(new Client(id, firstName, lastName, emailAdress, phoneNumber, companyId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static List<Company> loadCompanies(){
        List<Company> result = new ArrayList<>();
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.COMPANY_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                String name = res.getString("name");
                String adress = res.getString("address");
                String accountNumber = res.getString("accountNumber");
                boolean isRegular = res.getBoolean("isRegular");
                result.add(new Company(id, name, adress,accountNumber,isRegular, getClientsIdsForCompanyId(id)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static List<Plan> loadPlans() {
        List<Plan> result = new ArrayList<>();
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CAMPAIGN_PLAN_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                int estimatedRate = res.getInt("estimatedRate");
                String target = res.getString("target");
                ChannelType communicationChannel= ChannelType.valueOf(res.getString("communicationChannel"));
                result.add(new Plan(id, estimatedRate, target, communicationChannel, getCampaignIdByPlanId(id)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static double loadAnnualBonusForTeam(TeamType type){
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.ANNUAL_BONUS_TABLE + " WHERE team = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(type));

            res = pstmt.executeQuery();

            while(res.next()){
                return res.getDouble("bonus");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0.0;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0.0;
    }

    public static HashMap<EducationType, Double> loadEducationLevels(){

        HashMap<EducationType, Double> result = new HashMap<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.EDUCATION_LEVEL_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String eduLvl = res.getString("level");
                double factor = res.getDouble("factor");
                result.put(EducationType.valueOf(eduLvl), factor);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static HashMap<SettlementType, Double> loadPrices(){

        HashMap<SettlementType, Double> result = new HashMap<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.PRICE_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String type = res.getString("type");
                double value = res.getDouble("value");
                result.put(SettlementType.valueOf(type), value);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<Campaign> loadCampaigns() {
        List<Campaign> result = new ArrayList<>();
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CAMPAIGN_TABLE;
            pstmt = connection.prepareStatement(sql);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                String name = res.getString("name");
                Date startDate = res.getDate("startDate");
                Date endDate = res.getDate("endDate");
                int currentRate = res.getInt("currentRate");
                boolean needsNewCreation = res.getBoolean("needsNewCreation");
                SizeType size = SizeType.valueOf(res.getString("size"));
                boolean isAnimated = res.getBoolean("isAnimated");
                String creationDescription = res.getString("creationDescription");
                StatusType status = StatusType.valueOf(res.getString("status"));
                SettlementType settlementType = SettlementType.valueOf(res.getString("settlement"));
                String plannerId = res.getString("plannerId");
                String trafficId = res.getString("trafficId");
                String clientId = res.getString("clientId");
                String planId = res.getString("planId");
                String designerId = res.getString("designerId");
                String accountantId = res.getString("accountantId");
                String description = res.getString("description");
                Campaign campaign = new Campaign(id, name,startDate, endDate, currentRate, needsNewCreation, size, isAnimated, creationDescription, status, settlementType, planId, clientId, plannerId, trafficId, designerId, accountantId, description);
                result.add(campaign);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    private static String getCampaignIdByPlanId(String planId) {
        String result = "";

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CAMPAIGN_TABLE + " WHERE planId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, planId);

            res = pstmt.executeQuery();

            if(res.next()) return res.getString("id");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    private static List<String> getClientsIdsForCompanyId(String companyId) {
        List<String> result = new ArrayList<>();
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CLIENT_TABLE + " WHERE companyId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, companyId);

            res = pstmt.executeQuery();

            while(res.next()){
                result.add(res.getString("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    private static boolean isAccountantCompany(String accountantId) {
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT COUNT(*) FROM " + Utils.COMPANY_ACCOUNTANT_TABLE + " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, accountantId);

            res = pstmt.executeQuery();

            if(res.next()) return res.getInt(1) > 0;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static boolean isAccountantCampaign(String accountantId) {
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT COUNT(*) FROM " + Utils.CAMPAIGN_ACCOUNTANT_TABLE + " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, accountantId);

            res = pstmt.executeQuery();

            if(res.next()) return res.getInt(1) > 0;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static boolean isAccountantAIO(String accountantId){
        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT COUNT(*) FROM " + Utils.ACCOUNTANT_AIO_TABLE + " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, accountantId);

            res = pstmt.executeQuery();

            if(res.next()) return res.getInt(1) > 0;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static List<String> getSubordinatesIdByManagerId(String managerId, String subordinatesTable) {
        List<String> result = new ArrayList<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + subordinatesTable + " WHERE managerId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, managerId);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                result.add(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    private static List<String> readIds(String tableName){
        List<String> result = new ArrayList<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM "+tableName;
            pstmt = connection.prepareStatement(sql);
            res = pstmt.executeQuery();

            while (res.next()) {
                String id = res.getString("id");
                result.add(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    private static List<String> getCampaignsIdsByPlannerId(String plannerId){
        List<String> result = new ArrayList<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CAMPAIGN_TABLE + " WHERE plannerId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, plannerId);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                result.add(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    private static List<String> getCampaignsIdsByTrafficId(String trafficId){
        List<String> result = new ArrayList<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CAMPAIGN_TABLE + " WHERE trafficId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, trafficId);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                result.add(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    private static List<String> getCampaignsIdsByDesignerId(String trafficId){
        List<String> result = new ArrayList<>();

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.CAMPAIGN_TABLE + " WHERE designerId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, trafficId);

            res = pstmt.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                result.add(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    private static String getPlannerManagerIdByPlannerId(String plannerId){
        String result = "";

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.COMMUNICATION_PLANNER_TABLE + " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, plannerId);
            res = pstmt.executeQuery();

            if(res.next()) result = res.getString("managerId");

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    private static String getTrafficManagerIdByTrafficId(String trafficId){
        String result = "";

        Connection connection;
        try{
            Class.forName(Utils.DRIVER_NAME);
            connection = DriverManager.getConnection(Utils.URL, Utils.USR, Utils.PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM " + Utils.TRAFFIC_TABLE + " WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, trafficId);
            res = pstmt.executeQuery();

            if(res.next()) result = res.getString("managerId");

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
