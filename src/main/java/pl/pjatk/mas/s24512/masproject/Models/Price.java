package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.SettlementType;

import java.util.HashMap;
import java.util.Map;

public class Price {

    private static HashMap<SettlementType, Double> prices;

    public Price(HashMap<SettlementType, Double> prices) {
        this.prices = prices;
    }

    public HashMap<SettlementType, Double> getPrices() {
        return prices;
    }

    public static void setPrices(HashMap<SettlementType, Double> p) {
        prices = p;
    }

    public static double getPriceForSettlement(SettlementType type){
        if(prices.containsKey(type)) return prices.get(type);
        return 0.5;
    }
}
