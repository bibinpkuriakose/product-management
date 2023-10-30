package com.javahandsOn.productmanagement.service;

import com.javahandsOn.productmanagement.contract.ProductRequest;
import com.javahandsOn.productmanagement.model.Product;
import com.javahandsOn.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Long createProduct(ProductRequest request){
        Product entity = new Product(request.getName(), request.getCategory(), request.getPrice(),request.getStock());
        return productRepository.save(entity).getId();
    }
    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(long id){
        Product product = productRepository.findById(id);
        if(product==null){
            throw  new RuntimeException("Customer not found");
        }
        return product;
    }

    public Boolean updateProduct(long id,ProductRequest productRequest){
        Product item = productRepository.findById(id);
        if(item == null){
            return false;
        }else{
            item.setName(productRequest.getName());
            item.setCategory(productRequest.getCategory());
            item.setPrice(productRequest.getPrice());
            item.setStock(productRequest.getStock());
            return productRepository.save(item).getId() != null;
        }
    }
    public Boolean deleteProduct(long id){
        Product product = productRepository.findById(id);
        if(product == null){
            return false;
        }else{
            productRepository.deleteById(id);
            Product item = productRepository.findById(id);
            return item == null;
        }
    }
}
