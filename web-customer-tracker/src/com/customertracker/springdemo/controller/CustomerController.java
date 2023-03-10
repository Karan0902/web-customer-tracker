package com.customertracker.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customertracker.springdemo.dao.CustomerDAO;
import com.customertracker.springdemo.entity.Customer;
import com.customertracker.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
//	inject the customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
//		get customers from the customer service
		List<Customer> theCustomers = customerService.getCustomers();
		
//		add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
//		create model attribute to bind form data
		Customer newCustomer = new Customer();
		model.addAttribute("customer", newCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
//		save the customer using our service
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
//		get customer from db
		Customer theCustomer = customerService.getCustomer(theId);
		
//		set customer as a model attribute 
		theModel.addAttribute("customer", theCustomer);
		
//		send over to form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}

}
