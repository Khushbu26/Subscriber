package com.lucent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucent.model.Addresses;

public interface AddressesRepo extends JpaRepository<Addresses, Long>{

}
