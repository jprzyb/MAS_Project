package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Database.Load;
import pl.pjatk.mas.s24512.masproject.Models.enums.TeamType;

public class Test {
    public static void main(String[] args) {
        System.out.println("Planners: " + Load.loadCommunicationPlanners());
        System.out.println("Planners Managers: " + Load.loadCommunicationPlannerManagers());
        System.out.println("Traffics: " + Load.loadTraffics());
        System.out.println("Traffics Managers: " + Load.loadTrafficManagers());
        System.out.println("Traffics AIO: " + Load.loadTrafficsAIO());
        System.out.println("Designers: " + Load.loadDesigners());
        System.out.println("Accountants: " + Load.loadAccountants());
        System.out.println("Clients: " + Load.loadClients());
        System.out.println("Companies: " + Load.loadCompanies());
        System.out.println("Bonus planners: " + Load.loadAnnualBonusForTeam(TeamType.PLANNERS));
        System.out.println("Bonus traffics: " + Load.loadAnnualBonusForTeam(TeamType.TRAFFICS));
        System.out.println("Education level: " + Load.loadEducationLevels());
        System.out.println("Prices: " + Load.loadPrices());
    }
}
