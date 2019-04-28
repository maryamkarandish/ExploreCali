package com.example.ec.explorecali.domain;

/**
 * Created by m.karandish on 4/23/2019.
 */
public enum Difficulty {
    Easy("Easy"),Medium("Medium"),Difficult("Diffcult"), Varies("Varies");
    private String label;
    private Difficulty (String label){
        this.label = label;
    }

    public static Difficulty findByLabel (String byLabel){
        for(Difficulty rg: Difficulty.values()){
            if (rg.label.equalsIgnoreCase(byLabel)){
                return rg;
            }
        }
        return null;
    }

    public String getLabel() {
        return label;
    }
}
