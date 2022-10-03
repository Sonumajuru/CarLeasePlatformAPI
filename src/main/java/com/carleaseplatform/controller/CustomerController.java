package com.carleaseplatform.controller;

import com.carleaseplatform.entity.Customer;
import com.carleaseplatform.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController

/** Car Controller Class */
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /** Add operation */
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    /** Read operation */
    @GetMapping("/customers")
    public List<Customer> getCustomerList() {
        return customerService.getCustomerList();
    }

    /** Update operation */
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") Long customerId) {
        return customerService.updateCustomer(customer, customerId);
    }

    /** Delete operation */
    @DeleteMapping("/customers/{id}")
    public String deleteCustomerById(@PathVariable("id") Long customerId) {
        customerService.deleteCustomerById(customerId);
        return "Deleted Successfully";
    }
}