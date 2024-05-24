package com.rushiwarade.apidemo.controller;

import com.rushiwarade.apidemo.model.Products;
import com.rushiwarade.apidemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService ;

    @PostMapping
    public Products addProduct(@RequestBody Products products){
        return productService.addProduct(products);
    }
    @PutMapping
    public Products updateProduct(@RequestBody Products products){
        return productService.updateProduct(products);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Products products){
        productService.deleteProduct(products);
    }
    @GetMapping("/{id}")
    public Products getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Products> getAllProducts(){
        return (List<Products>) productService.getAllProducts();

    }

}
