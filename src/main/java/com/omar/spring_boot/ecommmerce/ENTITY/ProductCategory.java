package com.omar.spring_boot.ecommmerce.ENTITY;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = " ECProduct_CATEGORY")
@Getter
@Setter
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "CATEGORY_NAME")
    private String CATEGORY_NAME ;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private Set<Product> products ;
}
