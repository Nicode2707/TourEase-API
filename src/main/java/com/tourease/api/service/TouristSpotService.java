package com.tourease.api.service;

import com.tourease.api.dto.TouristSpotDTO;

import java.util.List;

public interface TouristSpotService {

    public TouristSpotDTO createSpot(TouristSpotDTO spot);

    public TouristSpotDTO getById(Integer id);

    public List<TouristSpotDTO> getAll();

    public TouristSpotDTO updateSpot(Integer id, TouristSpotDTO updatedSpot);

    public void deleteSpot(Integer id);

    public List<TouristSpotDTO> findByCity(String city);

    public List<TouristSpotDTO> findByType(String type);

    public List<TouristSpotDTO> findByRating(Double minRating);


}