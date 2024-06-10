package pl.pjatk.mas.s24512.masproject.DBUtils;

import pl.pjatk.mas.s24512.masproject.Repository.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Campaigns {
    private static final String URL = "jdbc:sqlserver://KUBUS;trustServerCertificate=true";
    private static final String USR = "MAS";
    private static final String PASS = "MAS";
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static List<Campaign> getCampaignsForPlannerWithId(String plannerId) {
        List<Campaign> result = new ArrayList<>();

        Connection connection;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM Campaign WHERE plannerId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, plannerId);
            res = pstmt.executeQuery();
            while (res.next()) {
                String id = res.getString("id");
                String name = res.getString("name");
                Date startDate = res.getDate("startDate");
                Date endDate = res.getDate("endDate");
                int currentRate = res.getInt("currentRate");
                boolean needsNewCreation = Boolean.valueOf(res.getString("needsNewCreation"));
                CreationType size = CreationType.valueOf(res.getString("size").toUpperCase());
                boolean isAnimated = Boolean.valueOf(res.getString("isAnimated"));
                String creationDescription = res.getString("creationDescription");
                CampaignStatus status = CampaignStatus.valueOf(res.getString("status").toUpperCase());
                String trafficId = res.getString("trafficId");
                String clientId = res.getString("clientId");
                String planId = res.getString("planId");
                String designerId = res.getString("designerId");
                result.add(new Campaign(
                        id, name, startDate, endDate, currentRate, needsNewCreation, size, isAnimated, creationDescription,
                        status, plannerId, trafficId, clientId, planId, designerId
                ));
            }
            return result;
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
    }

    public static boolean addCampaignToDB(Campaign campaign) {
        Connection connection;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;
        System.out.println(campaign);

        try {
            String sql = "INSERT INTO Campaign (id, name, startDate, endDate, currentRate, needsNewCreation, size, isAnimated, creationDescription, status, plannerId, trafficId, clientId, planId, designerId) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, campaign.getId());
            pstmt.setString(2, campaign.getName());
            pstmt.setDate(3, campaign.getStartDate());
            pstmt.setDate(4, campaign.getEndDate());
            pstmt.setInt(5, campaign.getCurrentRate());
            pstmt.setString(6, String.valueOf(campaign.needsNewCreation()));
            pstmt.setString(7, String.valueOf(campaign.getSize()));
            pstmt.setString(8, String.valueOf(campaign.isAnimated()));
            pstmt.setString(9, campaign.getCreationDescription());
            pstmt.setString(10, String.valueOf(campaign.getStatus()));
            pstmt.setString(11, campaign.getPlannerId());
            pstmt.setString(12, campaign.getTrafficId());
            pstmt.setString(13, campaign.getClientId());
            pstmt.setString(14, campaign.getPlanId());
            pstmt.setString(15, campaign.getDesignerId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected == 1;
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

    public static boolean addPlanToDB(Plan plan) {
        Connection connection;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO CampaignPlan(id, estimatedRate, target, communicationChannel) VALUES (?,?,?,?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, plan.getId());
            pstmt.setInt(2, plan.getEstimatedRate());
            pstmt.setString(3, plan.getTarget());
            pstmt.setString(4, String.valueOf(plan.getCommunicationChannel()));

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected == 1;
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

    public static List<Campaign> getCampaignsForTrafficWithId(String trafficId) {
        List<Campaign> result = new ArrayList<>();

        Connection connection;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM Campaign WHERE trafficId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, trafficId);
            res = pstmt.executeQuery();
            while (res.next()) {
                String id = res.getString("id");
                String name = res.getString("name");
                Date startDate = res.getDate("startDate");
                Date endDate = res.getDate("endDate");
                int currentRate = res.getInt("currentRate");
                boolean needsNewCreation = Boolean.valueOf(res.getString("needsNewCreation"));
                CreationType size = CreationType.valueOf(res.getString("size").toUpperCase());
                boolean isAnimated = Boolean.valueOf(res.getString("isAnimated"));
                String creationDescription = res.getString("creationDescription");
                CampaignStatus status = CampaignStatus.valueOf(res.getString("status").toUpperCase());
                String plannerId = res.getString("plannerId");
                String clientId = res.getString("clientId");
                String planId = res.getString("planId");
                String designerId = res.getString("designerId");
                result.add(new Campaign(
                        id, name, startDate, endDate, currentRate, needsNewCreation, size, isAnimated, creationDescription,
                        status, plannerId, trafficId, clientId, planId, designerId
                ));
            }
            return result;
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
    }

    public static List<Campaign> getTrafficUnasignedCampaigns() {
        List<Campaign> result = new ArrayList<>();

        Connection connection;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM Campaign WHERE trafficId = '' OR trafficId IS NULL";
            pstmt = connection.prepareStatement(sql);
            res = pstmt.executeQuery();
            while (res.next()) {
                String id = res.getString("id");
                String name = res.getString("name");
                Date startDate = res.getDate("startDate");
                Date endDate = res.getDate("endDate");
                int currentRate = res.getInt("currentRate");
                boolean needsNewCreation = Boolean.valueOf(res.getString("needsNewCreation"));
                CreationType size = CreationType.valueOf(res.getString("size").toUpperCase());
                boolean isAnimated = Boolean.valueOf(res.getString("isAnimated"));
                String creationDescription = res.getString("creationDescription");
                CampaignStatus status = CampaignStatus.valueOf(res.getString("status").toUpperCase());
                String plannerId = res.getString("plannerId");
                String trafficId = res.getString("trafficId");
                String clientId = res.getString("clientId");
                String planId = res.getString("planId");
                String designerId = res.getString("designerId");
                result.add(new Campaign(
                        id, name, startDate, endDate, currentRate, needsNewCreation, size, isAnimated, creationDescription,
                        status, plannerId, trafficId, clientId, planId, designerId
                ));
            }
            return result;
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
    }

    public static Plan getPlanById(String planId) {
        Plan result = null;

        Connection connection;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM CampaignPlan WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, planId);
            res = pstmt.executeQuery();
            if (res.next()) {
                String id = res.getString("id");
                int esimatedRate = res.getInt("estimatedRate");
                String target = res.getString("target");
                CommunicationChannels communicationChannel = CommunicationChannels.valueOf(res.getString("communicationChannel"));
                result = new Plan(id,esimatedRate,target,communicationChannel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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