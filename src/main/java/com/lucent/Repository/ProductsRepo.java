package com.lucent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucent.model.Products;

public interface ProductsRepo extends JpaRepository<Products, Long>{

}
