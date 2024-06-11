package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.SettlementType;

import java.util.Map;

public class Price {

    private static Map<SettlementType, Double> prices;

    public Price(Map<SettlementType, Double> prices) {
        this.prices = prices;
    }

    public Map<SettlementType, Double> getPrices() {
        return prices;
    }

    public void setPrices(Map<SettlementType, Double> prices) {
        this.prices = prices;
    }

    public static double getPriceForSettlement(SettlementType type){
        if(prices.containsKey(type)) return prices.get(type);
        return 0.5;
    }
}
