package com.tourease.api.repository;

import com.tourease.api.entity.TouristSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TouristSpotRepository extends JpaRepository<TouristSpot,Integer> {

    List<TouristSpot> findByCityIgnoreCase(String city);
    List<TouristSpot> findByTypeIgnoreCase(String type);
    List<TouristSpot> findByRatingGreaterThanEqual(Double minRating);

}
