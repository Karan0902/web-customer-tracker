package com.customertracker.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customertracker.springdemo.dao.CustomerDAO;
import com.customertracker.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
//	need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		
//		get the custoemers from the DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
//		add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		
		return "list-customers";
	}

}
