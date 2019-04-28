package com.example.ec.explorecali.repos;

import com.example.ec.explorecali.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


/**
 * Created by m.karandish on 4/23/2019.
 */
//public interface TourRepository extends CrudRepository<Tour,Integer> {
public interface TourRepository extends PagingAndSortingRepository<Tour,Integer> {
//    List<Tour> findByTourPackageCode(@Param("code") String code);
        Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);
        }
