package pl.pjatk.mas.s24512.masproject.DBUtils;

import pl.pjatk.mas.s24512.masproject.Repository.Company;

import java.sql.*;

public class Companies {

    private static final String URL = "jdbc:sqlserver://KUBUS;trustServerCertificate=true";
    private static final String USR = "MAS";
    private static final String PASS = "MAS";
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static Company getCompanyById(String id){
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
            String sql = "SELECT * FROM Company";
            pstmt = connection.prepareStatement(sql);
            res = pstmt.executeQuery();

            if (res.next()) {
                String name = res.getString("name");
                String address = res.getString("address");
                String accountNumber = res.getString("accountNumber");
                boolean isRegular = Boolean.valueOf(res.getString("isRegular"));
                return new Company(id,name,address,accountNumber,isRegular);
            }
            return null;
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
}
