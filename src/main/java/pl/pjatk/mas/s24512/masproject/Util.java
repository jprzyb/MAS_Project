package pl.pjatk.mas.s24512.masproject;

import pl.pjatk.mas.s24512.masproject.Database.Load;
import pl.pjatk.mas.s24512.masproject.Database.Save;
import pl.pjatk.mas.s24512.masproject.Models.*;
import pl.pjatk.mas.s24512.masproject.Models.enums.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Util {
    public static RoleType LOGGED_ON_ROLE;
    public static List<CommunicationPlanner> communicationPlanners;
    public static List<CommunicationPlannerManager> communicationPlannerManagers;
    public static List<Traffic> traffics;
    public static List<TrafficManager> trafficManagers;
    public static List<TrafficAIO> trafficsAIO;
    public static List<Company> companies;
    public static List<Client> clients;
    public static List<Campaign> campaigns;
    public static List<Plan> plans;
    public static List<Accountant> accountants;
    public static List<Designer> designers;
    public static void loadData(){
        CommunicationPlannerManager.setAnnualBonus(Load.loadAnnualBonusForTeam(TeamType.PLANNERS));
        TrafficManager.setAnnualBonus(Load.loadAnnualBonusForTeam(TeamType.TRAFFICS));
        Price.setPrices(Load.loadPrices());
        EducationLevel.setMap(Load.loadEducationLevels());
        communicationPlanners = Load.loadCommunicationPlanners();
        communicationPlannerManagers = Load.loadCommunicationPlannerManagers();
        traffics = Load.loadTraffics();
        trafficManagers = Load.loadTrafficManagers();
        trafficsAIO = Load.loadTrafficsAIO();
        companies = Load.loadCompanies();
        clients = Load.loadClients();
        campaigns = Load.loadCampaigns();
        plans = Load.loadPlans();
        accountants = Load.loadAccountants();
        designers = Load.loadDesigners();
    }
    public static void saveData(){
        Save.saveCommunicationPlanners();
        Save.saveTraffics();
        Save.saveAccountants();
        Save.saveCommunicationPlannerManagers();
        CommunicationPlannerManager.setAnnualBonus(1.0);
        Save.saveAnnualBonuses();
        Save.saveCampaigns();
        Save.savePlans();
        Save.saveClients();
        Save.saveCompanies();
        Save.saveDesigners();
        Save.saveTrafficsAIO();
        Save.saveTrafficManagers();
    }
    public static CommunicationPlanner getCommunicationPlannerById(String id) {
        for (CommunicationPlanner o : communicationPlanners) if(o.getId().equals(id)) return o;
        return null;
    }
    public static CommunicationPlannerManager getCommunicationPlannerManagerById(String id) {
        for (CommunicationPlannerManager o : communicationPlannerManagers) if(o.getId().equals(id)) return o;
        return null;
    }
    public static Traffic getTrafficById(String id) {
        for (Traffic o : traffics) if(o.getId().equals(id)) return o;
        return null;
    }
    public static TrafficManager getTrafficManagerById(String id) {
        for (TrafficManager o : trafficManagers) if(o.getId().equals(id)) return o;
        return null;
    }
    public static TrafficAIO getTrafficAIOById(String id) {
        for (TrafficAIO o : trafficsAIO) if(o.getId().equals(id)) return o;
        return null;
    }
    public static Company getCompanyById(String id){
        for(Company o : companies) if(o.getId().equals(id)) return o;
        return null;
    }
    public static Client getClientById(String id){
        for(Client o : clients) if(o.getId().equals(id)) return o;
        return null;
    }

    public static String getEmployeeIdByLogin(String login){
        for(CommunicationPlanner p : communicationPlanners) if(p.getLogin().equals(login)) return p.getId();
        for(CommunicationPlannerManager p : communicationPlannerManagers) if(p.getLogin().equals(login)) return p.getId();
        return "";
    }

    public static RoleType getRoleById(String id){
        for(CommunicationPlanner p : communicationPlanners){
            if(p.getId().equals(id)) return RoleType.COMMUNICATION_PLANNER;
        }
        for(CommunicationPlannerManager p : communicationPlannerManagers) if(p.getId().equals(id)) return RoleType.COMMUNICATION_PLANNER_MANAGER;
        return null;
    }

    public static boolean validateLogin(String login, String pass){
        for(CommunicationPlanner p : communicationPlanners){
//            System.out.println(p.getLogin() + " " + p.getPassword() + " == " + login + " " + pass);
            if(p.getLogin().equals(login) && p.getPassword().equals(pass)) return true;
        }
        for(CommunicationPlannerManager p : communicationPlannerManagers){
//            System.out.println(p.getLogin() + " " + p.getPassword() + " == " + login + " " + pass);
            if(p.getLogin().equals(login) && p.getPassword().equals(pass)) return true;
        }
        return false;
    }
}
