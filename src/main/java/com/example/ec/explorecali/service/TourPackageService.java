package com.example.ec.explorecali.service;

import com.example.ec.explorecali.domain.TourPackage;
import com.example.ec.explorecali.repos.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by m.karandish on 4/23/2019.
 */
@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name){
        if(!tourPackageRepository.existsById(code)){
            return tourPackageRepository.save(new TourPackage(code,name));
        }else{
            return null;
        }
    }

    public Iterable<TourPackage> lookup(){
        return tourPackageRepository.findAll();
    }

    public long total(){
        return tourPackageRepository.count();
    }
}
