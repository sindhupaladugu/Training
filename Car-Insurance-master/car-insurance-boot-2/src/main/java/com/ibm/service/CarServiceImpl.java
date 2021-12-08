package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Car;
import com.ibm.entity.Customer;
import com.ibm.repo.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository repo;

	@Autowired
	private CustomerService cservice;

	@Override
	public String add(Car c, int customerId) {
		Customer c1 = cservice.fetchById(customerId);
		List<Car> car = repo.findAll();
		if (!car.isEmpty()) {
			for (Car c2 : car) {
				if (c2.getRegNo().equals(c.getRegNo())) {
					return "Car already exists";
				} 
			}
		}
		c.setCustomer(c1);
		repo.save(c);
		return "Car added";

	}

	@Override
	public Car fetchById(int carId) {
		return repo.findById(carId).get();
	}

	@Override
	public List<Car> fetchAll() {

		return repo.findAll();
	}

	@Override
	public double getQuotation(String regNo, String coverageType) {

		Car c = repo.findByRegNo(regNo);
		double price = c.getPrice();
		double premium = price * 2 / 100;
		double idv = 0;
		int currntYr = 2021;
		int tenure = currntYr - c.getManufctYear();

		if (coverageType.equals("thirdparty")) {
			if (tenure <= 2) {
				idv = price - price * 60 / 100;

			} else if (tenure > 2 && tenure <= 4  ) {
				idv = price - price * 35 / 100;

			} else if(tenure > 4 && tenure <=6 ){
				idv = price - price * 20 / 100;
			}
		} else {
			if (tenure <= 2) {
				idv = price - price * 40 / 100;

			} else if (tenure > 2 && tenure <= 4  ) {
				idv = price - price * 25 / 100;

			} else if(tenure > 4 && tenure <=6 ){
				idv = price - price * 10 / 100;
			}
		}
		return idv * (premium / price);
	}

	@Override
	public void deleteCarById(int id) {
		repo.deleteById(id);
	}

}