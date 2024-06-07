package pl.pjatk.mas.s24512.masproject.DBUtils;

import pl.pjatk.mas.s24512.masproject.Repository.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            String sql = "SELECT * FROM Company WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
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
    public static List<Company> getAllCompanies(){
        List<Company> result = new ArrayList<>();
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

            while (res.next()) {
                String id = res.getString("id");
                String name = res.getString("name");
                String address = res.getString("address");
                String accountNumber = res.getString("accountNumber");
                boolean isRegular = Boolean.valueOf(res.getString("isRegular"));
                result.add(new Company(id, name, address, accountNumber, isRegular));
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

    public static boolean insertCompany(Company company){
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO Company(id, name, address, accountNumber, isRegular) " +
                    "VALUES (?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, company.getId());
            pstmt.setString(2, company.getName());
            pstmt.setString(3, company.getAddress());
            pstmt.setString(4, company.getAccountNumber());
            pstmt.setString(5, String.valueOf(company.getIsRegular()));

            int affectedRows = pstmt.executeUpdate();
            return affectedRows == 1;
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
