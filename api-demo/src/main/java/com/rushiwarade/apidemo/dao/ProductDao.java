package com.rushiwarade.apidemo.dao;

import com.rushiwarade.apidemo.model.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Products,Integer> {

}
