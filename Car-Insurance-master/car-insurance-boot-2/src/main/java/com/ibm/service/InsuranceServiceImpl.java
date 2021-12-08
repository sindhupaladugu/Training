package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Car;
import com.ibm.entity.Insurance;

import com.ibm.repo.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	private InsuranceRepository repo;

	@Autowired
	private CarService cservice;

	@Override
	public String save(Insurance i, int carId) {
		Car c = cservice.fetchById(carId);
		i.setCar(c);
		List<Insurance> ins = repo.findAll();
		if (!ins.isEmpty()) {
			for (Insurance i1 : ins) {
				if (i1.getCar().getCarId() == i.getCar().getCarId()) {
					return "Insurance already exists";
				}
			}
		}
		repo.save(i);
		return "Insurance added";
	}

	@Override
	public void deleteInsById(int id) {
		repo.deleteById(id);

	}

//	@Override
//	public Insurance fetchById(int insId) {
//
//		return repo.getById(insId);
//	}

}