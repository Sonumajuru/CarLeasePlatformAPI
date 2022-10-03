package com.carleaseplatform.controller;

import com.carleaseplatform.entity.Car;
import com.carleaseplatform.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

/** Car Controller Class */
public class CarController {

    @Autowired
    private CarService carService;

    /** Add operation */
    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car) {
        car.setLeaseRate(getLeaseRate(car));
        return carService.addCar(car);
    }

    /** Read operation */
    @GetMapping("/cars")
    public List<Car> getCarList() {
        return carService.getCarList();
    }

    /** Update operation */
    @PutMapping("/cars/{id}")
    public Car updateCar(@RequestBody Car car, @PathVariable("id") Long carId) {
        car.setLeaseRate(getLeaseRate(car));
        return carService.updateCar(car, carId);
    }

    /** Delete operation */
    @DeleteMapping("/cars/{id}")
    public String deleteCarById(@PathVariable("id") Long carId) {
        carService.deleteCarById(carId);
        return "Deleted Successfully";
    }

    /** Method calculate lease rate */
    public double getLeaseRate(Car car) {
        double leaseRate = (((double) (( car.getMileage() / 12 ) * car.getDuration()) / car.getNettPrice()) + ((( car.getInterestRate() / 100 ) * car.getNettPrice()) / 12));
        return Double.parseDouble(String.format("%.02f", leaseRate));
    }
}