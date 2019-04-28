package com.example.ec.explorecali.service;

import com.example.ec.explorecali.domain.Difficulty;
import com.example.ec.explorecali.domain.Region;
import com.example.ec.explorecali.domain.Tour;
import com.example.ec.explorecali.domain.TourPackage;
import com.example.ec.explorecali.repos.TourPackageRepository;
import com.example.ec.explorecali.repos.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by m.karandish on 4/23/2019.
 */
@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour (String title, String description, String blurb, double price, String duration,
                            String bullets, String keyword, String tourPackageName, Difficulty difficulty,
                            Region region){
       TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
        if(tourPackage == null){
            throw new RuntimeException("Tour Package does not exist:: " + tourPackageName);
        }
        return tourRepository.save(new Tour(title,description,blurb,price,duration,bullets,
                keyword,tourPackage,difficulty,region ));

    }

    public Iterable<Tour> lookup(){
        return tourRepository.findAll();
    }

    public long total(){
        return tourRepository.count();
    }
}
