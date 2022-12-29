package com.omar.spring_boot.ecommmerce.CONFIG;

import com.omar.spring_boot.ecommmerce.ENTITY.Product;
import com.omar.spring_boot.ecommmerce.ENTITY.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/*
@Configuration

public class MyDataRest implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
// disable methods for prodeuct : put , post and delete
        HttpMethod[] theUnSupportedActions = {HttpMethod.PUT , HttpMethod.POST , HttpMethod.DELETE};
        config.getExposureConfiguration().forDomainType(Product.class).withItemExposure((
                (metdata, httpMethods) -> httpMethods.disable(theUnSupportedActions))
                ).withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnSupportedActions)));
// disable methods for prodeuctcategory : put , post and delete

        config.getExposureConfiguration().forDomainType(ProductCategory.class).withItemExposure((
                (metdata, httpMethods) -> httpMethods.disable(theUnSupportedActions))
        ).withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnSupportedActions)));

    }


}
*/