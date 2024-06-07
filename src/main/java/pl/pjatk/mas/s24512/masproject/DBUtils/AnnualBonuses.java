package pl.pjatk.mas.s24512.masproject.DBUtils;

import java.sql.*;

public class AnnualBonuses {

    private static final String URL = "jdbc:sqlserver://KUBUS;trustServerCertificate=true";
    private static final String USR = "MAS";
    private static final String PASS = "MAS";
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static double getAnnualBonusForPlanners(){
        return getAnnualBonus("planners");
    }
    public static double getAnnualBonusForTraffics(){
        return getAnnualBonus("traffics");
    }
    private static double getAnnualBonus(String team){
       double result = 0.0;

        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT bonus FROM AnnualBonus WHERE team = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, team);
            res = pstmt.executeQuery();
            if (res.next()) {
                result = res.getDouble("bonus");
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

    public static boolean setAnnualBonusForPlanners(Double bonus){
        return setAnnualBonus("planners",bonus);
    }
    public static boolean setAnnualBonusForTraffics(Double bonus){
        return setAnnualBonus("traffics",bonus);
    }
    private static boolean setAnnualBonus(String team, Double bonus){
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "UPDATE AnnualBonus SET bonus = ? WHERE team = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, bonus);
            pstmt.setString(2, team);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
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
