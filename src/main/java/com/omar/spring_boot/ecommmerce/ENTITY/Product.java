package com.omar.spring_boot.ecommmerce.ENTITY;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="ECProduct")
@Data
public class Product {

    @Id
    @NonNull
    @Column(name = "ECP_Product_ID")
    private Integer id;
    @Column(name = "SKU")
    private String SKU ;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String DESCRIPTION ;
    @Column(name = "UNIT_PRICE")
     private Integer unitPrice ;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Column(name = "ACTIVE")
    private int active ;
    @Column(name = "UNITS_IN_STOCK")
    private int unitsInStock ;
    @Column(name = "DATE_CREATED")
    @CreationTimestamp
    private Date dateCreated ;
    @Column(name = "LAST_UPDATED")
    @UpdateTimestamp
    private Date lastUpdated ;
    @ManyToOne
    @JoinColumn(name = " CATEGORY_ID",nullable = false)
private ProductCategory category ;

    public Product() {

    }
}
