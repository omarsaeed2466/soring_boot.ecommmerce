package com.omar.spring_boot.ecommmerce.Cont;

import com.omar.spring_boot.ecommmerce.DAO.ProductRepostitory;
import com.omar.spring_boot.ecommmerce.ENTITY.Product;
import com.omar.spring_boot.ecommmerce.Service.ProductService;
import com.omar.spring_boot.ecommmerce.Service.ProductServiceImp;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProductControl {
  @Autowired
     private ProductRepostitory productRepostitory ;
    @Autowired
private ProductService productService ;



// get all products  //difference between Field , Constructor , method @autowiring
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepostitory.findAll();
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getproductById(@PathVariable(value = "id") Long productId)
            throws ResourceNotFoundException {
        Product product = productRepostitory.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/products")
    public Product createProduct(@Validated @RequestBody Product product ) throws Exception {
    return  productService.save(product);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
                                                   @Validated @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepostitory.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
product.setName(productDetails.getName());
product.setSKU(productDetails.getSKU());
product.setDESCRIPTION(productDetails.getDESCRIPTION());
product.setImageUrl(productDetails.getImageUrl());
product.setActive(productDetails.getActive());
product.setUnitPrice(productDetails.getUnitPrice());
product.setUnitsInStock(productDetails.getUnitsInStock());
product.setDateCreated(productDetails.getDateCreated());
product.setLastUpdated(productDetails.getLastUpdated());
product.setCategory(productDetails.getCategory());


        final Product updatedproduct = productRepostitory.save(product);
        return ResponseEntity.ok(updatedproduct);
    }

    @DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
            throws ResourceNotFoundException {
        Product product = productRepostitory.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("proudct not found for this id :: " + productId));

        productRepostitory.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
