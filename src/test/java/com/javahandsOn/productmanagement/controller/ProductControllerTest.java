package com.javahandsOn.productmanagement.controller;

import com.javahandsOn.productmanagement.contract.ProductRequest;
import com.javahandsOn.productmanagement.model.Product;
import com.javahandsOn.productmanagement.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

//    @Test
//    void createProductTest() throws Exception{
//        ProductRequest productRequest = new ProductRequest();
//        productRequest.setName("i");
//        productRequest.setCategory("i");
//        productRequest.setPrice(1L);
//        productRequest.setStock(1L);
//        when(productService.createProduct(productRequest)).thenReturn(1L);
//        mockMvc.perform(post("/products"))
//                .andDo(print())
//                .andExpect(status().isCreated());
//    }

    @Test
    void getAllProductsTest() throws Exception{
        Product product = new Product();
        product.setId(1L);
        product.setName("i");
        product.setCategory("i");
        product.setPrice(1L);
        product.setStock(1L);
        List<Product> products = new ArrayList<Product>();
        products.add(product);
        when(productService.getAllProducts()).thenReturn(products);
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
    }

    @Test
    void getProductByIdTest() throws Exception{
        Product product = new Product();
        product.setId(1L);
        product.setName("i");
        product.setCategory("i");
        product.setPrice(1L);
        product.setStock(1L);
        when(productService.getProductById(product.getId())).thenReturn(product);
        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk());
    }

//    @Test
//    void updateProductTest() throws Exception{
//        ProductRequest productRequest = new ProductRequest();
//        productRequest.setName("i");
//        productRequest.setCategory("i");
//        productRequest.setPrice(1L);
//        productRequest.setStock(1L);
//        when(productService.updateProduct(1L, productRequest)).thenReturn(true);
//        mockMvc.perform(put("/products/1"))
//                .andExpect(status().isOk());
//    }

    @Test
    void deleteProduct() throws Exception{
        when(productService.deleteProduct(1L)).thenReturn(true);
        mockMvc.perform(delete("/products/1"))
                .andExpect(status().isOk());
    }
}
