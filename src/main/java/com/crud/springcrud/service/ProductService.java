package com.crud.springcrud.service;

import java.util.List;

import com.crud.springcrud.entity.Products;
import com.crud.springcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Products saveProduct(Products product) {
        return repository.save(product);
    }

    public List<Products> saveProducts(List<Products> products) {
        return repository.saveAll(products);
    }

    public List<Products> getProduct(){
        return repository.findAll();
    }

    public Products getProductById(int id){
        return repository.findById(id).orElse(null);
    }
}
