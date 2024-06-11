package pl.pjatk.mas.s24512.masproject;

import pl.pjatk.mas.s24512.masproject.Models.*;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static Runnable LOGGED_ON_ROLE;
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
        communicationPlanners = new ArrayList<>();
        communicationPlannerManagers = new ArrayList<>();
        traffics = new ArrayList<>();
        trafficManagers = new ArrayList<>();
        trafficsAIO = new ArrayList<>();
        companies = new ArrayList<>();
        clients = new ArrayList<>();
        campaigns = new ArrayList<>();
        plans = new ArrayList<>();
        accountants = new ArrayList<>();
        accountants = new ArrayList<>();
    }

    public static void saveData(){

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
}
