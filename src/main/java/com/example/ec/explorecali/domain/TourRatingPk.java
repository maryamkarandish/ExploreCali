package com.example.ec.explorecali.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by m.karandish on 4/27/2019.
 */
@Embeddable
public class TourRatingPk implements Serializable {
    @ManyToOne
    private Tour tour;

    @Column(insertable = false, nullable = false, updatable = false)
    private Integer customerId;

    public TourRatingPk(){
    }

    public TourRatingPk(Tour tour, Integer customerId){
        this.tour = tour;
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TourRatingPk that = (TourRatingPk) o;

        if (!tour.equals(that.tour)) return false;
        return customerId.equals(that.customerId);

    }

    @Override
    public int hashCode() {
        int result = tour.hashCode();
        result = 31 * result + customerId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TourRatingPk{" +
                "tour=" + tour +
                ", customerId=" + customerId +
                '}';
    }
    public Tour getTour() {
        return tour;
    }

    public Integer getCustomerId() {
        return customerId;
    }
}
