package com.carleaseplatform.service;

import com.carleaseplatform.entity.Car;
import com.carleaseplatform.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

/** CarServiceCalls Class */
public class CarServiceCalls implements CarService {

    @Autowired
    private CarRepo carRepo;


    /** Add operation */
    @Override
    public Car addCar(Car car) {
        return carRepo.save(car);
    }

    /** Read operation */
    @Override
    public List<Car> getCarList() {
        return (List<Car>) carRepo.findAll();
    }

    /** Update operation */
    @Override
    public Car updateCar(Car car, Long carId) {

        Car depDB = carRepo.findById(carId).get();

        if (Objects.nonNull(car.getMake()) && !"".equalsIgnoreCase(car.getMake())) {
            depDB.setMake(car.getMake());
        }

        if (Objects.nonNull(car.getModel()) && !"".equalsIgnoreCase(car.getModel())) {
            depDB.setModel(car.getModel());
        }

        if (Objects.nonNull(car.getVersion())) {
            depDB.setVersion(car.getVersion());
        }

        if (Objects.nonNull(car.getNumberOfDoors())) {
            depDB.setNumberOfDoors(car.getNumberOfDoors());
        }

        if (Objects.nonNull(car.getCO2Emission())) {
            depDB.setCO2Emission(car.getCO2Emission());
        }

        if (Objects.nonNull(car.getGrossPrice())) {
            depDB.setGrossPrice(car.getGrossPrice());
        }

        if (Objects.nonNull(car.getNettPrice())) {
            depDB.setNettPrice(car.getNettPrice());
        }

        if (Objects.nonNull(car.getMileage())) {
            depDB.setMileage(car.getMileage());
        }

        if (Objects.nonNull(car.getDuration())) {
            depDB.setDuration(car.getDuration());
        }

        if (Objects.nonNull(car.getInterestRate())) {
            depDB.setInterestRate(car.getInterestRate());
        }

        return carRepo.save(depDB);
    }

    /** Delete operation */
    @Override
    public void deleteCarById(Long carId) {
        carRepo.deleteById(carId);
    }
}


