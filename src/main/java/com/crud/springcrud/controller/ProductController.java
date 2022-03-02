package com.crud.springcrud.controller;

import java.util.List;

import com.crud.springcrud.entity.Products;
import com.crud.springcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Products addProduct(@RequestBody Products product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Products> addProduct(@RequestBody List<Products> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Products> findAllProducts() {
        return service.getProduct();
    }

    @GetMapping("/productById/{id}")
    public Products findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Products findProductByName(@PathVariable String name) {
        return service.getProductsByName(name);
    }

    @PutMapping("/updateProduct")
    public  Products updateProduct(@RequestBody Products product){
        return service.updateProduct(product);
    } 

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);

    }
}
