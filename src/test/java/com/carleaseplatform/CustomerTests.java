package com.carleaseplatform;

import com.carleaseplatform.entity.Customer;
import com.carleaseplatform.service.CustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerTests {
	@Autowired
	CustomerService customerService;

	/** Set testing values to check with test case */
	Customer customer = new Customer(1L,"Simon Onumajuru", "Dauphinelaan", "30", "5627 CP", "Eindhoven", "sonumajuru@gmail.com","0684029091");

	@DisplayName("getCustomerByPosition")
	@Test
	void getCustomerByPosition() {
		assertEquals(customer, customerService.getCustomerList().get(0));
	}
}
