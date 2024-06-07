package pl.pjatk.mas.s24512.masproject.DBUtils;

import java.sql.*;

public class EmployeesTypes {
    private static final String URL = "jdbc:sqlserver://KUBUS;trustServerCertificate=true";
    private static final String USR = "MAS";
    private static final String PASS = "MAS";
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static boolean IsCommunicationPlanner(String id){
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try { // communication
            String sql = "SELECT COUNT(*) FROM CommunicationPlanner WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            res = pstmt.executeQuery();
            if(res.next()) return res.getInt(1) == 1;
            return false;
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean IsTraffic(String id){
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try { // communication
            String sql = "SELECT COUNT(*) FROM Traffic WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            res = pstmt.executeQuery();
            if(res.next()) return res.getInt(1) == 1;
            return false;
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean IsPlannerManager(String id){
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try { // communication
            String sql = "SELECT COUNT(*) FROM PlannerManager WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            res = pstmt.executeQuery();
            if(res.next()) return res.getInt(1) == 1;
            return false;
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean IsTrafficManager(String id){
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try { // communication
            String sql = "SELECT COUNT(*) FROM TrafficManager WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            res = pstmt.executeQuery();
            if(res.next()) return res.getInt(1) == 1;
            return false;
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean IsTrafficAIO(String id){
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;


        try { // communication
            String sql = "SELECT COUNT(*) FROM TrafficAIO WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            res = pstmt.executeQuery();
            if(res.next()) return res.getInt(1) == 1;
            return false;
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean IsDesigner(String id){
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try { // communication
            String sql = "SELECT COUNT(*) FROM Designer WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            res = pstmt.executeQuery();
            if(res.next()) return res.getInt(1) == 1;
            return false;
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean IsCampaignAccountant(String id){
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try { // communication
            String sql = "SELECT COUNT(*) FROM CampaignAccountant WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            res = pstmt.executeQuery();
            if(res.next()) return res.getInt(1) == 1;
            return false;
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean IsCorporateAccountant(String id){
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try { // communication
            String sql = "SELECT COUNT(*) FROM CompanyAccountant WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            res = pstmt.executeQuery();
            if(res.next()) return res.getInt(1) == 1;
            return false;
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean IsAccountantAIO(String id){
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try { // communication
            String sql = "SELECT COUNT(*) FROM AccountantAIO WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            res = pstmt.executeQuery();
            if(res.next()) return res.getInt(1) == 1;
            return false;
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
