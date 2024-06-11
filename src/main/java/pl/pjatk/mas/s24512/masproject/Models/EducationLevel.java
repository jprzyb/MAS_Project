package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.EducationType;

import java.util.Map;

public class EducationLevel {
    private static Map<EducationType, Double> map;
    private EducationType educationType;
    public EducationLevel(String value){
        try{
            educationType = EducationType.valueOf(value);
        }catch (Exception e){
            e.printStackTrace();
            educationType = null;
        }
    }
    public static void setMap(Map<EducationType, Double> m){
        map = m;
    }
    public double getFactor(){
        if(!map.containsKey(educationType)) return 1.0;
        return map.get(educationType);
    }
}
