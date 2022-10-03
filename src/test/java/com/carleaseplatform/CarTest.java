package com.carleaseplatform;

import com.carleaseplatform.entity.Car;
import com.carleaseplatform.service.CarService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CarTest {
    @Autowired
    CarService carService;

    /** Set testing values to check with test case */
    Car car = new Car(5L,"Toyota", "Camry", 2008, 4, 200, 45000, 63000,45000, 60, 4.5, 239.76);

    @DisplayName("getCarByPosition")
    @Test
    void getCarByPosition() {
        assertEquals(car, carService.getCarList().get(0));
    }
}
