package com.greatlearning.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.crm.model.Customer;

@Service

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int cId);

	public void save(Customer cCustomer);

	public void deleteById(int cId);

}
