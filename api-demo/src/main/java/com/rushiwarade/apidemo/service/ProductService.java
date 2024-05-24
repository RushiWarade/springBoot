package com.rushiwarade.apidemo.service;

import com.rushiwarade.apidemo.dao.ProductDao;
import com.rushiwarade.apidemo.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao ;
    public Products addProduct(Products products){
        return productDao.save(products);
    }

    public Products updateProduct(Products products){
        return productDao.save(products);
    }
    public void deleteProduct(Products products){
         productDao.delete(products);
    }
     public Products getProductById(int id){
        return productDao.findById(id).get();
    }

    public List<Products> getAllProducts(){
      return (List<Products>) productDao.findAll();

    }

}
