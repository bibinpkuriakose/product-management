package com.javahandsOn.productmanagement.controller;

import com.javahandsOn.productmanagement.contract.ProductRequest;
import com.javahandsOn.productmanagement.model.Product;
import com.javahandsOn.productmanagement.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping()
    public @ResponseBody Long createProduct(@RequestBody ProductRequest request){
        return  productService.createProduct(request);
    }
    @GetMapping()
    public @ResponseBody List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public @ResponseBody Product getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public @ResponseBody Boolean updateProduct(@PathVariable long id,@RequestBody ProductRequest productRequest){
        return productService.updateProduct(id,productRequest);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody Boolean deleteProduct(@PathVariable long id){
        return productService.deleteProduct(id);
    }
}
