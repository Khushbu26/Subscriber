package com.lucent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucent.model.Customers;

public interface CustomerRepo extends JpaRepository<Customers, Long>{

}
