package com.tourease.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TouristSpotDTO {

    private Integer id;
    private String name;
    private String city;
    private String type;
    private Double  rating;

}
