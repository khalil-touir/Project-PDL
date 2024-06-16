package com.sesame.projectpdl.Services;

import com.sesame.projectpdl.Entity.Product;
import com.sesame.projectpdl.Repository.ProductRepository;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
public class ProductServices implements IProductServices {
    @Autowired
    public ProductRepository productRepository;

    @Override
    public Product getProductById(Long Id) {
        return productRepository.findById(Id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>((Collection)productRepository.findAll());
        return products;
    }

    @Override
    public void DeleteProduitById(Long Id) {
        productRepository.deleteById(Id);
    }

    @Override
    public Product UpdateProduct(Product product, Long Id) {
        Product product1 = productRepository.findById(Id).orElseThrow(() -> new RuntimeException("Product not found"));
        product1.setCategorie(product.getCategorie());
        product1.setNom(product.getNom());
        product1.setPrix(product.getPrix());
        product1.setDim(product.getDim());
        product1.setImage(product.getImage());
        product1.setMatriel(product.getMatriel());

        return productRepository.save(product);
    }

    @Override
    public Product AddProduct(Product product) {
        return productRepository.save(product);
    }
}