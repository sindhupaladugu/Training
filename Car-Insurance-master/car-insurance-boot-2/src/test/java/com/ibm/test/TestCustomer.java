package com.ibm.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ibm.entity.Customer;
import com.ibm.service.CustomerService;



public class TestCustomer {
	@Autowired
	private CustomerService service;
	
	@Test
	public void testSave() {
		Customer c = new Customer();
		c.setCustomerId(1);
		c.setName("dhara");
		c.setPhoneNumber(991177558);
		c.setCity("Prakasam");
		c.setEmail("sindhu2269@gmail.com");
		c.setPassword("fedcba");
		
		service.save(c);
		
	}
	
	@Test
	public void testFetchById() {
		Customer c = service.fetchById(1);
		System.out.println("Customer"+ c.getName()+ "," + c.getCity()+ ","+
				c.getPhoneNumber()+ "," + c.getEmail()+ "," + c.getPassword()+"," + c.getCar());
				
		
		

	}
	
	@Test
	public void testFetchAll() {
		List<Customer> list = service.fetchAll();
		for (Customer customer : list) {
			System.out.println(customer.getCustomerId() + "," + customer.getName()+ "," + customer.getCity()+ ","+
		customer.getPhoneNumber()+ "," + customer.getEmail()+ "," + customer.getPassword()+"," + customer.getCar());
		}
		
	}
}