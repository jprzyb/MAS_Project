package pl.pjatk.mas.s24512.masproject.LoginUtils;

import pl.pjatk.mas.s24512.masproject.BussinessUtils.Employee;
import pl.pjatk.mas.s24512.masproject.Util;

public class Login {
    public static String APPROVE_LOGIN_MSG = "fgy8ibehjwef8ywebhgboijweg";
    public static String tryToLogin(String login, String pass){
        String DBresponse = DB.tryToLogin(login,pass);
        if(DBresponse.equals(login + " | " + pass)){
            Util.setEmployeeLoggedOn(DB.getUsrWithLogin(login));
            return APPROVE_LOGIN_MSG;
        }
        return DBresponse;

    }
}
