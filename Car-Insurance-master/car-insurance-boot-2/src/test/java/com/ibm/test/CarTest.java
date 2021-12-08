package com.ibm.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.entity.Car;

import com.ibm.service.CarService;

public class CarTest {
 
	@Autowired
	private CarService repo;
	
	@Test
	public void testAdd() {
		Car c = new Car();
		c.setCarId(19);
		c.setRegNo("GHT67ED");
		c.setModelName("BMW Audi3"); 
		c.setPurchYear('2018');
		c.setExpiryYear('2021');  
		c.setPrice(); 
		c.setCustomer();
		repo.add(c, 2);
	}
		@Test
		public void testFetchById() {
			Car c1 = repo.fetchById(1);
			System.out.println( c1.getRegNo() + ", "+ c1.getModelName() + "," + c1.getManufctYear() + "," + c1.getPurchYear() + "," + c1.getPrice() );

		}
		
		@Test
		public void testFetchAll() {
			List<Car> list = repo.fetchAll();
			for (Car car : list) {
				System.out.println(car.getCarId()+ "," + car.getRegNo()+ "," + car.getModelName() + ","+ car.getPurchYear()+ car.getExpiryYear() + "," + car.getPrice() + "," + car.getCustomer());
			}
		}
}