package com.example.ec.explorecali.repos;

import com.example.ec.explorecali.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by m.karandish on 4/23/2019.
 */
public interface TourPackageRepository extends CrudRepository<TourPackage,String> {

    TourPackage findByName(String name);
}
