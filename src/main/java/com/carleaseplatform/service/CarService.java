package com.carleaseplatform.service;

import com.carleaseplatform.entity.Car;
import java.util.List;

/** Interface Class */
public interface CarService {

    /** Add operation */
    Car addCar(Car car);

    /** Read operation */
    List<Car> getCarList();

    /** Update operation */
    Car updateCar(Car car, Long carId);

    /** Delete operation */
    void deleteCarById(Long card);
}
