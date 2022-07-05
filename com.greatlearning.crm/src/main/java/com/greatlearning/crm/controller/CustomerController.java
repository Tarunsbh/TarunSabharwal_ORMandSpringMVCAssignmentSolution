package com.greatlearning.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.crm.model.Customer;
import com.greatlearning.crm.service.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	public CustomerServiceImpl customerService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String list(Model theModel) {
		System.out.println("Request Received");
		List<Customer> theCustomers = customerService.findAll();
		theModel.addAttribute("Customers", theCustomers);
		return "customer-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind customer form data

		Customer theCustomer = new Customer();
		theModel.addAttribute("Customer", theCustomer);
		return "customer-form";

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {
		// get the customer data from the service

		Customer theCustomer = customerService.findById(id);
		// set customer data as a model attribute to pre-populate the form

		theModel.addAttribute("Customer", theCustomer);
		// send over to customer form

		return "customer-form";
	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("eMail") String eMail) {
		System.out.println(id);
		Customer theCustomer;
		if (id != 0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.seteMail(eMail);

		} else {
			theCustomer = new Customer(firstName, lastName, eMail);
		}
		// save the customer data

		customerService.save(theCustomer);

		// redirect to /customer/list

		return "redirect:/customer/list";

	}

	@RequestMapping("/deleteById")
	// delete the customer data
	public String delete(@RequestParam("customerId") int theId) {
		System.out.println(theId);
		customerService.deleteById(theId);
		return "redirect:/customer/list";

	}
}
