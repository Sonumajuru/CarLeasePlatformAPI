package com.carleaseplatform.entity;

// Importing package modules

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

/** Car model Class */

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;
    private String make;
    private String model;
    private Integer version;
    private Integer numberOfDoors;
    private Integer cO2Emission;
    private Integer grossPrice;
    private Integer nettPrice;
    private Integer mileage;
    private Integer duration;
    private double interestRate;
    private double leaseRate;
}


