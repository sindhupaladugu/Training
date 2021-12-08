package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
	
	Insurance findByCoverageType(String s);
	
	

}
