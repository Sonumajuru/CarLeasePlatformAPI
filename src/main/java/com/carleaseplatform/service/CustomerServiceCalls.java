package com.carleaseplatform.service;

import com.carleaseplatform.entity.Customer;
import com.carleaseplatform.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service

/** CustomerServiceCalls Class */
public class CustomerServiceCalls implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    /** Add operation */
    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    /** Read operation */
    @Override
    public List<Customer> getCustomerList() {
        return (List<Customer>) customerRepo.findAll();
    }

    /** Update operation */
    @Override
    public Customer updateCustomer(Customer customer, Long customerId) {

        Customer depDB = customerRepo.findById(customerId).get();

        if (Objects.nonNull(customer.getName()) && !"".equalsIgnoreCase(customer.getName())) {
            depDB.setName(customer.getName());
        }

        if (Objects.nonNull(customer.getStreet()) && !"".equalsIgnoreCase(customer.getStreet())) {
            depDB.setStreet(customer.getStreet());
        }

        if (Objects.nonNull(customer.getHouseNumber()) && !"".equalsIgnoreCase(customer.getHouseNumber())) {
            depDB.setHouseNumber(customer.getHouseNumber());
        }

        if (Objects.nonNull(customer.getZipCode()) && !"".equalsIgnoreCase(customer.getZipCode())) {
            depDB.setZipCode(customer.getZipCode());
        }

        if (Objects.nonNull(customer.getPlace()) && !"".equalsIgnoreCase(customer.getPlace())) {
            depDB.setPlace(customer.getPlace());
        }

        if (Objects.nonNull(customer.getEmailAddress()) && !"".equalsIgnoreCase(customer.getEmailAddress())) {
            depDB.setEmailAddress(customer.getEmailAddress());
        }

        if (Objects.nonNull(customer.getPhoneNumber()) && !"".equalsIgnoreCase(customer.getPhoneNumber())) {
            depDB.setPhoneNumber(customer.getPhoneNumber());
        }

        return customerRepo.save(depDB);
    }

    /** Delete operation */
    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepo.deleteById(customerId);
    }
}

