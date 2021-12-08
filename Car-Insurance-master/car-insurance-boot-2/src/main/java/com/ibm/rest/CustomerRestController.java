package com.ibm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Customer;

import com.ibm.service.CustomerService;

@CrossOrigin
@RestController
public class CustomerRestController {
	 
	@Autowired
	private CustomerService service;
	
	@PostMapping(value = "/customer", consumes ="application/json")
	public void addCustomer(@RequestBody Customer customer) {
		service.save(customer);
	
	}
	
	@GetMapping(value = "/customer/{customerid}", produces = "application/json")
	public Customer getCustomer(@PathVariable int customerid) {
		Customer c = service.fetchById(customerid);
		return c;
	}

}