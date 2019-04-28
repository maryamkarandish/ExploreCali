package com.example.ec.explorecali.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by m.karandish on 4/23/2019.
 */
@Entity
public class TourPackage implements Serializable{
    @Id
    private String code;

    @Column
    private String name;

    protected TourPackage(){

    }

    public TourPackage(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "TourPackage{Code=" + code +", Name="+name+"}";
    }

//    @OneToMany
//    private Tour tour;
}
