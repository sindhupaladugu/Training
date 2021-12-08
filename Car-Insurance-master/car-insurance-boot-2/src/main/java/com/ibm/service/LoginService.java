package com.ibm.service;

import org.springframework.stereotype.Service;

import com.ibm.entity.Customer;


public interface LoginService {
	
	Customer Authenticate(String email,String password);

}