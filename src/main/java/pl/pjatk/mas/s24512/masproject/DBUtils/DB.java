package pl.pjatk.mas.s24512.masproject.DBUtils;

import java.sql.*;

public class DB {
    private static final String URL = "jdbc:sqlserver://SCLAP45;trustServerCertificate=true";
    private static final String USR = "MAS";
    private static final String PASS = "MAS";
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection connection;
    public DB(){
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USR, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
