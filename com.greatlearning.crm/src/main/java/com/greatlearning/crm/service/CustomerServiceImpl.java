package com.greatlearning.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.crm.model.Customer;
import com.greatlearning.crm.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	public CustomerRepository cdata;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return cdata.findAll();
	}

	@Override
	public Customer findById(int cId) {
		// TODO Auto-generated method stub
		return cdata.findById(cId);
	}

	@Override
	public void save(Customer cCustomer) {
		// TODO Auto-generated method stub
		cdata.save(cCustomer);

	}

	@Override
	public void deleteById(int cId) {
		// TODO Auto-generated method stub
		cdata.deleteById(cId);

	}

}
