package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import com.TRA.tra24Springboot.Repositories.ProductDetailsRepository;
import com.TRA.tra24Springboot.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class ProductServices {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDetailsServices productDetailsServices;


    public Product addProduct(Product product){


        ProductDetails productDetails = productDetailsServices.addProductDetails(product.getProductDetails());
        /**ProductDetails productDetails = productDetailsServices.addProductDetails(product.getProductDetails());
       **/
        product.setProductDetails(productDetails);
        product.setSku(UUID.randomUUID());
        product.setCategory("Electronics Devices ");
         product.setQuantity(78);
        product.setIsActive(Boolean.TRUE);
        product.setCreatedDate(new Date());

        return productRepository.save(product);

    }
    public String deleteProduct(String productName){
          Product productFromDb = productRepository.getByProductName(productName);
          productFromDb.setIsActive(Boolean.FALSE);
          productRepository.save(productFromDb);
        return "Success";
    }
    public String deleteProductById(Integer productId){

        Product productFromDb = productRepository.getProductById(productId);
        productFromDb.setIsActive(Boolean.FALSE);
        productRepository.save(productFromDb);
        return "Success";
    }

    public String updateProductQuantity(Integer productId, Integer quantity) {
        Product productFromDb = productRepository.getProductById(productId);
        productFromDb.setQuantity(quantity);
        productFromDb.setUpdatedDate(new Date());

        productRepository.save(productFromDb);
        return "Updated Successfully";
    }
    public Product updateProduct(Product product)
    {
        return productRepository.save(product);
    }
}
