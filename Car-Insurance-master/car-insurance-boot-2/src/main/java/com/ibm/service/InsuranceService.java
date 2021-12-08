package com.ibm.service;

import com.ibm.entity.Insurance;

public interface InsuranceService {
	
	String save(Insurance i, int carId);

	void deleteInsById(int id);

}