package com.crud.springcrud.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS_TBL")
public class Products {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private double price;

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price2) {
        this.price = price2;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity2) {
        this.quantity = quantity2;
    }

    public Integer getId() {
        return this.id;
    }

}
