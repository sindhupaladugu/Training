package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Customer;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerService service;

	@Override
	public Customer Authenticate(String email, String password) {
		List<Customer> list = service.fetchAll();
		for (Customer customer : list) {
			if (customer.getEmail().equals(email)) {
				if (customer.getPassword().equals(password)) {
					return customer;
				}
			}
		}
		return null;
	}

}