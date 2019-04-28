package com.example.ec.explorecali.domain;

/**
 * Created by m.karandish on 4/23/2019.
 */
public enum Region {
    Central_Coast("Central Coast"), Southern_California("Southern California"), Northern_California("Northern California"), Varies("Varies");
    private String label;
    private Region (String label){
        this.label = label;
    }
    public static Region findByLabel (String byLabel){
        for(Region rg: Region.values()){
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
