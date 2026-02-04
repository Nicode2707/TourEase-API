package com.tourease.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
    @Table
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class TouristSpot {

        @Id
        @SequenceGenerator(initialValue = 100,allocationSize = 1,name = "TouristSpotSeq" )
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TouristSpotSeq")
        @Column(name="TsID")
        private Integer id;
        @Column(name="TsName",length = 30)
        private String name;
        @Column(name="TsCity",length = 30)
        private String city;
        @Column(name="TsType",length = 30)
        private String type;
        @Column(name="TsRating")
        private Double  rating;

        @CreationTimestamp
        private LocalDateTime createdAt;
        @UpdateTimestamp
        private LocalDateTime updatedAt;
        @Version
        private Integer totalUpdateCount;

    }

