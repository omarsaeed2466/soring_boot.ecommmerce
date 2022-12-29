package com.omar.spring_boot.ecommmerce.Service;

import com.omar.spring_boot.ecommmerce.DAO.ProductRepostitory;
import com.omar.spring_boot.ecommmerce.ENTITY.Product;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    ProductRepostitory productRepostitory ;


    @Override
    public boolean  beforeSave(Product product) throws Exception {

        if (product.getUnitPrice() > 200)
            throw new Exception("The product exceeded the agreed price");



        return true;
    }
    @Override
    public void afterSave(Product product) {
if (product.getUnitPrice()>200){
    product.setUnitPrice(199);
}else{
    productRepostitory.save(product);
}

    }


    public Product save(Product product) throws Exception {
        if(beforeSave(product))
            product =   productRepostitory.saveAndFlush(product);
    try {
        afterSave(product);
    }catch(Exception ex){

        ex.printStackTrace();;
    }
        return product;
    }

}
