package com.carleaseplatform.service;

import com.carleaseplatform.entity.Customer;
import java.util.List;

/** Interface Class */
public interface CustomerService {

    /** Add operation */
    Customer addCustomer(Customer customer);

    /** Read operation */
    List<Customer> getCustomerList();

    /** Update operation */
    Customer updateCustomer(Customer customer, Long customerId);

    /** Delete operation */
    void deleteCustomerById(Long customerId);
}

