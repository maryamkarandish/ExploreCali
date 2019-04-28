package com.example.ec.explorecali.web;

import com.example.ec.explorecali.domain.Tour;
import com.example.ec.explorecali.domain.TourRating;
import com.example.ec.explorecali.domain.TourRatingPk;
import com.example.ec.explorecali.repos.TourRatingRepository;
import com.example.ec.explorecali.repos.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by m.karandish on 4/27/2019.
 */
@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {
    TourRatingRepository tourRatingRepository;
    TourRepository tourRepository;

    @Autowired
    public TourRatingController(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
        this.tourRatingRepository = tourRatingRepository;
        this.tourRepository = tourRepository;
    }
    public TourRatingController(){

    }

   @RequestMapping(method = RequestMethod.POST)
   @ResponseStatus(HttpStatus.CREATED)
    public void creatTourRating(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto){
        Tour tour = verifyTour(tourId);
        tourRatingRepository.save(new TourRating(new TourRatingPk(tour,ratingDto.getCustomerId()),ratingDto.getScore(),
                ratingDto.getComment()));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<RatingDto> getAllRatingForTour(@PathVariable(value = "tourId") int tourId){
        verifyTour(tourId);
       return tourRatingRepository.findByPkTourId(tourId).stream().map(tourRating -> toDto(tourRating)).collect(Collectors.toList());
    }

    @RequestMapping( method = RequestMethod.GET , path = "/average")
    public AbstractMap.SimpleEntry<String,Double> getAverage(@PathVariable(value = "tourId") int tourId){

        verifyTour(tourId);
        List<TourRating> tourRatings =  tourRatingRepository.findByPkTourId(tourId);
        OptionalDouble average = tourRatings.stream().mapToInt(TourRating::getScore).average();
        return new AbstractMap.SimpleEntry<String, Double>("average",average.isPresent()?average.getAsDouble():null);
    }


    private RatingDto toDto(TourRating tourRating){
        return new RatingDto(tourRating.getScore(),tourRating.getComment(),tourRating.getPk().getCustomerId());
    }
    public Tour verifyTour(int tourId) throws NoSuchElementException{
        Tour tour = tourRepository.findById(tourId).get();
        if (tour==null){
            throw new NoSuchElementException("Tour Does not exists!" + tourId);
        }
        return tour;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex){
        return ex.getMessage();
    }

}
