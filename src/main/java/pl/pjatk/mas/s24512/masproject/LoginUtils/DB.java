package pl.pjatk.mas.s24512.masproject.LoginUtils;

import java.sql.*;
public class DB {
    private static String URL = "jdbc:sqlserver://KUBUS;trustServerCertificate=true";
    private static String USR = "MAS";
    private static String PASS = "MAS";
    private static String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String QUERY = "SELECT * FROM Login WHERE login={login}";
//    private static String QUERY = "SELECT * FROM Login WHERE login={login} AND pass={pass}";
    private static Connection con;

    public static String tryToLogin(String login, String pass){

        try{ // connection
            Class.forName(DRIVER_NAME);
            con = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Statement statement = null;
        ResultSet res = null;
        try { // initiation
            statement = con.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try { // communication
            res = statement.executeQuery(setQuery(login, pass));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        boolean hasResult;
        try {
            hasResult = res.next();
            if (hasResult) {
                return res.getString("login") + " | " + res.getString("pass");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Wrong cridentials!";
    }

    private static String setQuery(String login, String pass){
        String res = QUERY.replace("{login}", "'"+login+"'").replace("{pass}", "'"+pass+"'");
        return res;
    }

}
