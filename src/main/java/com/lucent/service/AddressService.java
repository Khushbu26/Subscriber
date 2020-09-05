package com.lucent.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucent.Repository.AddressesRepo;
import com.lucent.model.Addresses;

@Service
@Transactional
public class AddressService {
	
	@Autowired
	private AddressesRepo addressesRepo;
	
	public void saveAddress(Addresses address) {
		addressesRepo.save(address);
	}

}
