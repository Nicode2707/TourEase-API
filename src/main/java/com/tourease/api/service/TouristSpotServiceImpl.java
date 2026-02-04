package com.tourease.api.service;

import com.tourease.api.dto.TouristSpotDTO;
import com.tourease.api.entity.TouristSpot;
import com.tourease.api.exception.SpotNotFoundException;
import com.tourease.api.repository.TouristSpotRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TouristSpotServiceImpl implements TouristSpotService {

    private final TouristSpotRepository repo;

    @Override
    @Transactional
    public TouristSpotDTO createSpot(TouristSpotDTO spotDto) {
        // convert DTO to entity
        TouristSpot entity = new TouristSpot();
        BeanUtils.copyProperties(spotDto, entity);

        // set current time
        LocalDateTime now = LocalDateTime.now();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);

        // save and return DTO
        TouristSpot saved = repo.save(entity);
        TouristSpotDTO dto = new TouristSpotDTO();
        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    @Override
    public TouristSpotDTO getById(Integer id) {
        // find entity
        TouristSpot spot = repo.findById(id)
                .orElseThrow(() -> new SpotNotFoundException("Record not found..!"));

        // convert to DTO
        TouristSpotDTO dto = new TouristSpotDTO();
        BeanUtils.copyProperties(spot, dto);
        return dto;
    }

    @Override
    public List<TouristSpotDTO> getAll() {
        List<TouristSpot> list = repo.findAll();
        List<TouristSpotDTO> dtoList = new ArrayList<TouristSpotDTO>();

        for (TouristSpot spot : list) {
            TouristSpotDTO dto = new TouristSpotDTO();
            BeanUtils.copyProperties(spot, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    @Transactional
    public TouristSpotDTO updateSpot(Integer id, TouristSpotDTO updatedSpot) {
        // find existing entity
        TouristSpot existing = repo.findById(id)
                .orElseThrow(() -> new SpotNotFoundException("Record not found..!"));

        // apply updates by copying new Data
        BeanUtils.copyProperties(updatedSpot, existing, "id", "createdAt");
        existing.setUpdatedAt(LocalDateTime.now());

        // save and return DTO
        TouristSpot saved = repo.save(existing);
        TouristSpotDTO dto = new TouristSpotDTO();
        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    @Override
    @Transactional
    public void deleteSpot(Integer id) {
        // check ID existence
        if (!repo.existsById(id)) {
            throw new SpotNotFoundException("Record not found..!");
        }
        //Delete the spot
        repo.deleteById(id);
    }

    @Override
    public List<TouristSpotDTO> findByCity(String city) {

        // fetch and convert list
        List<TouristSpot> list = repo.findByCityIgnoreCase(city);
        List<TouristSpotDTO> dtoList = new ArrayList<>();

        for (TouristSpot spot : list) {
            TouristSpotDTO dto = new TouristSpotDTO();
            BeanUtils.copyProperties(spot, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TouristSpotDTO> findByType(String type) {

        // fetch and convert list
        List<TouristSpot> list = repo.findByTypeIgnoreCase(type);
        List<TouristSpotDTO> dtoList = new ArrayList<>();

        for (TouristSpot spot : list) {
            TouristSpotDTO dto = new TouristSpotDTO();
            BeanUtils.copyProperties(spot, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TouristSpotDTO> findByRating(Double minRating) {

        // fetch and convert list
        List<TouristSpot> list = repo.findByRatingGreaterThanEqual(minRating);
        List<TouristSpotDTO> dtoList = new ArrayList<>();

        for (TouristSpot spot : list) {
            TouristSpotDTO dto = new TouristSpotDTO();
            BeanUtils.copyProperties(spot, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
