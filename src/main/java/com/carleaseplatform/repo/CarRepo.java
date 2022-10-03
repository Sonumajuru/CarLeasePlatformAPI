package com.carleaseplatform.repo;

import com.carleaseplatform.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

/** Interface extending CrudRepository */
public interface CarRepo extends CrudRepository<Car, Long> {
}
