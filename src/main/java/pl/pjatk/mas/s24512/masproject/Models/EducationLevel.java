package pl.pjatk.mas.s24512.masproject.Models;

import pl.pjatk.mas.s24512.masproject.Models.enums.EducationType;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class EducationLevel {
    private static HashMap<EducationType, Double> map;
    private EducationType educationType;
    public EducationLevel(String value){
        try{
            educationType = EducationType.valueOf(value);
        }catch (Exception e){
            educationType = null;
        }
    }
    public static void setMap(HashMap<EducationType, Double> m){
        map = m;
    }
    public double getFactor(){
        if(!map.containsKey(educationType)) return 1.0;
        return map.get(educationType);
    }

    public EducationType getEducationType(){
        return educationType;
    }
    public void setEducationType(EducationType educationType){
        this.educationType = educationType;
    }
}
