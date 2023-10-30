package com.javahandsOn.productmanagement.repository;

import com.javahandsOn.productmanagement.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    Product findById(long id);
}
