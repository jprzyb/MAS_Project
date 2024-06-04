package pl.pjatk.mas.s24512.masproject.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

    public static boolean tryToLogin(String login, String password){
        Connection connection = DB.getConnection();

        Statement statement = null;
        ResultSet res = null;
        try { // initiation
            statement = connection.createStatement();

        } catch (SQLException e) {
            return false;
        }

        try { // communication
            res = statement.executeQuery("SELECT COUNT(*) From Employee WHERE login LIKE"+login+" AND password LIKE " + password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
