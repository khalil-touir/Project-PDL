package com.sesame.projectpdl.Services;

import com.sesame.projectpdl.Entity.Product;

import java.util.List;

public interface IProductServices {
    public Product getProductById(Long Id);
    public List<Product> getAllProducts();
    public void DeleteProduitById(Long Id);
    public Product UpdateProduct(Product product,Long Id);
    public Product AddProduct(Product product);
}

