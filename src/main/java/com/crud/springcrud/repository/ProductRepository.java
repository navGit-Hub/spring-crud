package com.crud.springcrud.repository;

import com.crud.springcrud.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ProductRepository extends JpaRepository<Products, Integer> {
    Products findByName(String name);
}
    

