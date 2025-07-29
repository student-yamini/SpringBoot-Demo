package com.example.productlist.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    //one category has many products
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> products=new ArrayList<>();
}
