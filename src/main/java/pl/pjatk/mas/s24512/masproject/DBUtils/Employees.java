package pl.pjatk.mas.s24512.masproject.DBUtils;

import pl.pjatk.mas.s24512.masproject.Repository.Employee;
import pl.pjatk.mas.s24512.masproject.Repository.LevelOfEducation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employees {

    private static final String URL = "jdbc:sqlserver://KUBUS;trustServerCertificate=true";
    private static final String USR = "MAS";
    private static final String PASS = "MAS";
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static Employee getEmployeeByLogin(String login) {
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
            String sql = "SELECT * FROM Employee WHERE login = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, login);
            res = pstmt.executeQuery();

            if (res.next()) {
                String id = res.getString("id");
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                Double salary = res.getDouble("salary");
                String managerId = res.getString("managerId");
                LevelOfEducation levelOfEducation = LevelOfEducation.valueOf(res.getString("levelOfEducation").toUpperCase());

                Employee result = new Employee(id, firstName, lastName, login, password, birthDate, employmentDate, salary, managerId, levelOfEducation);
                return result;
            } else {
                return null;
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
    }
    public static double getFactoryForEduLevel(LevelOfEducation level){
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
            String sql = "SELECT factor FROM EducationLevel WHERE level = ?";
            String l = String.valueOf(level).toLowerCase();
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, l);
            res = pstmt.executeQuery();
            if(res.next()) return res.getDouble("factor");
        } catch (SQLException e) {
            return 1.0;
        }finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 1.0;
    }
    public static boolean setPassword(String password, String id){
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
            String sql = "UPDATE Employee SET password = ? WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setString(2, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
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

    public static Employee getEmployeeById(String id) {
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
            String sql = "SELECT * FROM Employee WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            res = pstmt.executeQuery();

            if (res.next()) {
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                String password = res.getString("password");
                Date birthDate = res.getDate("birthDate");
                Date employmentDate = res.getDate("employmentDate");
                Double salary = res.getDouble("salary");
                String managerId = res.getString("managerId");

                LevelOfEducation levelOfEducation = LevelOfEducation.NONE;
                String level = res.getString("levelOfEducation");
                if (level != null || !"NONE".equalsIgnoreCase(level)){
                    levelOfEducation = LevelOfEducation.valueOf(level.toUpperCase());
                }
                Employee result = new Employee(id, firstName, lastName, login, password, birthDate, employmentDate, salary, managerId, levelOfEducation);
                return result;
            } else {
                return null;
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
    }
    public static List<Employee> getSubordinates(String managerId){
        List<Employee> result = new ArrayList<>();

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
            String sql = "SELECT id FROM Employee WHERE managerId = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, managerId);
            res = pstmt.executeQuery();
            while (res.next()) {
                String id = res.getString("id");
                Employee r = getEmployeeById(id);
                result.add(r);
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

    public static boolean setSalary(Double salary, String id) {
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
            String sql = "UPDATE Employee SET salary = ? WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, salary);
            pstmt.setString(2, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
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
