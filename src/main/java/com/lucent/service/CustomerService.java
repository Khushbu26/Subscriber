package com.lucent.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucent.Repository.CustomerRepo;
import com.lucent.model.Customers;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	public void saveCustomer(Customers customer) {
		customerRepo.save(customer);
	}
}
