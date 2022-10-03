package com.carleaseplatform.repo;

import com.carleaseplatform.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

/** Interface extending CrudRepository */
public interface CustomerRepo extends CrudRepository<Customer, Long> {
}