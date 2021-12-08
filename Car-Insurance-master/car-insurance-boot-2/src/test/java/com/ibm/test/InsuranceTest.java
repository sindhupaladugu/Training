package com.ibm.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.entity.Insurance;
import com.ibm.service.InsuranceService;



public class InsuranceTest {
	
	@Autowired
	private InsuranceService repo;
	
	@Test
	public void testSave() {
		Insurance i = new Insurance();
		i.setInsId(123);
		i.setInsuranceNo(123435);
		i.setDateIssued("");
		i.setExpiryDate("");
		i.setAmount(34355);
		i.getDuration();
		i.setPrevAmntInsured('');
		i.setCar();
		repo.save(i, 1);
		
		
		
	}
	@Test
	public void testDelete() {
		repo.deleteInsById(1);
	}


}