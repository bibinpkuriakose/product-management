package com.javahandsOn.productmanagement.service;

import com.javahandsOn.productmanagement.model.Product;
import com.javahandsOn.productmanagement.repository.ProductRepository;
import com.javahandsOn.productmanagement.contract.ProductRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    void testCreateProduct(){
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("iiii");
        productRequest.setCategory("iiii");
        productRequest.setPrice(1L);
        productRequest.setStock(1L);
        Product product = new Product();
        product.setStock(productRequest.getStock());
        product.setPrice(productRequest.getPrice());
        product.setName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setId(1L);
        when(productRepository.save(any())).thenReturn(product);
        long id = productService.createProduct(productRequest);
        assertEquals(id,1L);
    }

    @Test
    void testGetAllProducts(){
        Product product = new Product();
        product.setId(1L);
        product.setName("i");
        product.setCategory("i");
        product.setPrice(1L);
        product.setStock(1L);
        List<Product> products = new ArrayList<Product>();
        products.add(product);
        when(productRepository.findAll()).thenReturn(products);
        List<Product> items = productService.getAllProducts();
        assertEquals(items.get(0).getId(),1L);
    }

    @Test
    void testGetProductById(){
        Product product = new Product();
        product.setId(1L);
        product.setName("i");
        product.setCategory("i");
        product.setPrice(1L);
        product.setStock(1L);
        when(productRepository.findById(1L)).thenReturn(product);
        Product item = productService.getProductById(1L);
        assertEquals(item.getId(),1L);
    }
    @Test
    void testDeleteProduct(){
        Product product = new Product();
        product.setId(1L);
        product.setName("i");
        product.setCategory("i");
        product.setPrice(1L);
        product.setStock(1L);
        when(productRepository.findById(1L)).thenReturn(product);
        Boolean item = productService.deleteProduct(1L);
        Mockito.verify(productRepository).deleteById(1L);
    }

    @Test
    void testUpdateProduct(){
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("iiii");
        productRequest.setCategory("iiii");
        productRequest.setPrice(1L);
        productRequest.setStock(1L);
        Product product = new Product();
        product.setStock(productRequest.getStock());
        product.setPrice(productRequest.getPrice());
        product.setName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setId(1L);
//        Product product = new Product();
//        product.setStock(11L);
//        product.setPrice(11L);
//        product.setName("iiii");
//        product.setCategory("iiii");
//        product.setId(1L);
        when(productRepository.findById(1L)).thenReturn(product);
        Boolean item = productService.updateProduct(1L,productRequest);
        assertEquals(item,true);
    }
}
