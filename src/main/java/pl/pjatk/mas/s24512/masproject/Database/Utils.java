package pl.pjatk.mas.s24512.masproject.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static final String URL = "jdbc:sqlserver://KUBUS;trustServerCertificate=true";
    public static final String USR = "MAS";
    public static final String PASS = "MAS";
    public static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static final String ACCOUNTANT_AIO_TABLE = "AccountantAIO";
    public static final String ANNUAL_BONUS_TABLE = "AnnualBonus";
    public static final String CAMPAIGN_TABLE = "Campaign";
    public static final String CAMPAIGN_ACCOUNTANT_TABLE = "CampaignAccountant";
    public static final String CAMPAIGN_PLAN_TABLE = "CampaignPlan";
    public static final String CLIENT_TABLE = "Client";
    public static final String COMMUNICATION_PLANNER_TABLE = "CommunicationPlanner";
    public static final String COMPANY_TABLE = "Company";
    public static final String COMPANY_ACCOUNTANT_TABLE = "CompanyAccountant";
    public static final String DESIGNER_TABLE = "Designer";
    public static final String EDUCATION_LEVEL_TABLE = "EducationLevel";
    public static final String EMPLOYEE_TABLE = "Employee";
    public static final String COMMUNICATION_PLANNER_MANAGER_TABLE = "PlannerManager";
    public static final String PRICE_TABLE = "Price";
    public static final String TRAFFIC_TABLE = "Traffic";
    public static final String TRAFFIC_AIO_TABLE = "TrafficAIO";
    public static final String TRAFFIC_MANAGER_TABLE = "TrafficManager";
}
