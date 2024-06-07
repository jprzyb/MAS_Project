package pl.pjatk.mas.s24512.masproject.DBUtils;

import pl.pjatk.mas.s24512.masproject.Repository.Client;
import pl.pjatk.mas.s24512.masproject.Repository.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Clients {

    private static final String URL = "jdbc:sqlserver://KUBUS;trustServerCertificate=true";
    private static final String USR = "MAS";
    private static final String PASS = "MAS";
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static List<Client> getAllClients(){
        List<Client> result = new ArrayList<>();

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
            String sql = "SELECT * FROM Client";
            pstmt = connection.prepareStatement(sql);
            res = pstmt.executeQuery();

            while (res.next()) {
                String id = res.getString("id");
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String emailAddress = res.getString("emailAddress");
                String phoneNumber = res.getString("phoneNumber");
                String companyId = res.getString("companyId");
                Client c = new Client(id, firstName,lastName,emailAddress,phoneNumber,companyId);
                result.add(c);
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
    public static boolean insertClient(Client client){
        Connection connection;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO Client(id, firstName, lastName, emailAddress, phoneNumber, companyId) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, client.getId());
            pstmt.setString(2, client.getFirstName());
            pstmt.setString(3, client.getLastName());
            pstmt.setString(4, client.getEmailAdress());
            pstmt.setString(5, client.getPhoneNumber());
            pstmt.setString(6, client.getCompanyId());

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
