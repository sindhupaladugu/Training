package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
	
	Car findByRegNo(String r);
	
	List<Car> findAllByCustomer(int c);
}
