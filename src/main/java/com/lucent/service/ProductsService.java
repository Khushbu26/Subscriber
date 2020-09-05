package com.lucent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucent.Repository.ProductsRepo;
import com.lucent.model.Products;

@Service
@Transactional
public class ProductsService {

  @Autowired
  private ProductsRepo productsRepo;

  public void saveProducts(Products products) {
    productsRepo.save(products);
  }

  public List<Products> getAllProduct() {
    // TODO Auto-generated method stub
    return productsRepo.findAll();
  }

}
