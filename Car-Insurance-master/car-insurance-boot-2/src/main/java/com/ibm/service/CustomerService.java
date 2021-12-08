package com.ibm.service;

import java.util.List;

import com.ibm.entity.Customer;

public interface CustomerService {
	
	void save(Customer c);
	
	Customer fetchById(int customer_id);
	
	List<Customer> fetchAll();

}
