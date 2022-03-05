package com.crud.springcrud.repository;

import java.util.List;
import com.crud.springcrud.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Integer> {
    Products findByName(String name);
}
