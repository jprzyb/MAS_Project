package pl.pjatk.mas.s24512.masproject.DBUtils;

import java.sql.*;

public class Login {

    private static final String URL = "jdbc:sqlserver://KUBUS;trustServerCertificate=true";
    private static final String USR = "MAS";
    private static final String PASS = "MAS";
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static boolean tryToLogin(String login, String password) {
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ResultSet res = null;
        PreparedStatement pstmt = null;
        int var = 0;

        try { // communication
            String sql = "SELECT COUNT(*) FROM Employee WHERE login = ? AND password = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            res = pstmt.executeQuery();
            if(res.next()) var = res.getInt(1);

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
        return var == 1;
    }
}
