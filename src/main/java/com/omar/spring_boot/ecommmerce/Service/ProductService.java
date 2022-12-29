package com.omar.spring_boot.ecommmerce.Service;

import com.omar.spring_boot.ecommmerce.ENTITY.Product;

public interface ProductService {
     boolean beforeSave(Product product ) throws Exception;
    void afterSave(Product product);

    public Product save(Product product) throws Exception;
}
