package com.sesame.projectpdl.Controller;

import com.sesame.projectpdl.Entity.Product;
import com.sesame.projectpdl.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {

        @Autowired
        ProductServices productServices;

        @GetMapping("/GettAll")
        public List<Product> getAllProducts(){
            return productServices.getAllProducts();
        }
        @GetMapping("/GetById/{id}")
        public Product getProductById(@PathVariable("id") Long Id){
            return productServices.getProductById(Id);
        }
        @DeleteMapping("/delete/{id}")
        public void DeleteProductById(@PathVariable("id") Long Id){
            productServices.DeleteProduitById(Id);
        }
        @PostMapping("/update/{id}")
        public Product UpdateProduct(@RequestBody Product product,@PathVariable("id") Long Id){
            return productServices.UpdateProduct(product,Id);
        }
        @PostMapping("/Add")
        public Product AddProduct(@RequestBody Product product){
            return productServices.AddProduct(product);

        }
    }

