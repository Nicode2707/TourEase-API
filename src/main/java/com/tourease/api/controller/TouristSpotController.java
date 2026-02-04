package com.tourease.api.controller;

import com.tourease.api.dto.TouristSpotDTO;
import com.tourease.api.service.TouristSpotService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tourist-spot")
public class TouristSpotController {

    private final TouristSpotService service;

    // Create TouristSpot
    @PostMapping("/add-spot")
    public ResponseEntity<String> createSpot(@RequestBody TouristSpotDTO spotDto) {
        TouristSpotDTO created = service.createSpot(spotDto);
        String body = "Spot created successfully with ID: " + created.getId();
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    // Get TouristSpot by ID
    @GetMapping("/get-spot/{id}")
    public ResponseEntity<TouristSpotDTO> getById(@PathVariable Integer id) {
        TouristSpotDTO dto = service.getById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // Get all TouristSpot (paginated)
    @GetMapping("/get-all-spots")
    public ResponseEntity<List<TouristSpotDTO>> getAll() {
        List<TouristSpotDTO> list = service.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Update TouristSpot
    @PutMapping("/update-spot/{id}")
    public ResponseEntity<String> updateSpot(@PathVariable Integer id,
                                             @RequestBody TouristSpotDTO updatedSpot) {
        TouristSpotDTO dto = service.updateSpot(id, updatedSpot);
        String body = "Spot updated successfully for ID: " + dto.getId();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    // Delete TouristSpot
    @DeleteMapping("/delete-spot/{id}")
    public ResponseEntity<String> deleteSpot(@PathVariable Integer id) {
        service.deleteSpot(id);
        String body = "Spot deleted successfully with ID: " + id;
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    // Find TouristSpot by city
    @GetMapping("/city/{city}")
    public ResponseEntity<List<TouristSpotDTO>> findByCity(@PathVariable String city) {
        List<TouristSpotDTO> list = service.findByCity(city);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Find TouristSpot by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<TouristSpotDTO>> findByType(@PathVariable String type) {
        List<TouristSpotDTO> list = service.findByType(type);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Find TouristSpot by minimum rating
    @GetMapping("/rating")
    public ResponseEntity<List<TouristSpotDTO>> findByRating(@RequestParam("min") Double minRating) {
        List<TouristSpotDTO> list = service.findByRating(minRating);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
