package pl.pjatk.mas.s24512.masproject.LoginUtils;

public class Login {
    public static String tryToLogin(String login, String pass){
        String DBresponse = DB.tryToLogin(login,pass);
        if(DBresponse.equals(login + " | " + pass)){
            return "Poprawnie zalogowano!";
        }
        return DBresponse;

    }
}
