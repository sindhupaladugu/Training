package com.ibm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "cars")
public class Car {
	@Id
	@GeneratedValue
	private int carId;
	
	@Column(length = 20 , name = "reg_no")
	private String regNo;
	
	@Column(length = 20 , name = "model_name")
	private String modelName;

	
	@Column(length = 20, name = "manufct_yr")
	private int manufctYear;
	
	@Column(length = 20,name = "purch_yr")
	private int purchYear;
	
	@Column(length = 20 , name = "price")
	private double price;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "car" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ins_id")
	private Insurance insurance;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	
	public int getManufctYear() {
		return manufctYear;
	}

	public void setManufctYear(int manufctYear) {
		this.manufctYear = manufctYear;
	}

	public int getPurchYear() {
		return purchYear;
	}

	public void setPurchYear(int purchYear) {
		this.purchYear = purchYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", regNo=" + regNo + ", modelName=" + modelName + ", manufctYear=" + manufctYear
				+ ", purchYear=" + purchYear + ", price=" + price + ", customer=" + customer + ", insurance="
				+ insurance + "]";
	}




}