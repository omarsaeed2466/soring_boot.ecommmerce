package com.omar.spring_boot.ecommmerce.DAO;

import com.omar.spring_boot.ecommmerce.ENTITY.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@Repository
public interface ProductRepostitory extends JpaRepository<Product,Long> {


}
