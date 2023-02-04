package com.customertracker.springdemo.dao;

import java.util.List;

import com.customertracker.springdemo.entity.Customer;


public interface CustomerDAO {
	
	public List<Customer> getCustomers();
}
