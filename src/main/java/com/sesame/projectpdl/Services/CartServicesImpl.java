package com.sesame.projectpdl.Services;

import com.sesame.projectpdl.Entity.Cart;
import com.sesame.projectpdl.Entity.Product;
import com.sesame.projectpdl.Entity.User;
import com.sesame.projectpdl.Repository.CartRepository;
import com.sesame.projectpdl.Repository.ProductRepository;
import com.sesame.projectpdl.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServicesImpl implements ICarteServices{
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Transactional
    public Cart getCartByUser(String name) {
        User user = userRepository.findByname(name);
        return cartRepository.findByUser((org.apache.catalina.User) user);
    }

    @Override
    public void addProductToCart(String name, Long Id) {
        User user = userRepository.findByname(name);
        Cart cart = cartRepository.findByUser((org.apache.catalina.User) user);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
        }

        Product product = productRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        cart.getProducts().add(product);

        cartRepository.save(cart);
    }

    @Override
    public void removeProductFromCart(String name, Long Id) {
        User user = userRepository.findByname(name);
        Cart cart = cartRepository.findByUser((org.apache.catalina.User) user);

        if (cart != null) {
            Product product = productRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
            cart.getProducts().remove(product);

            cartRepository.save(cart);
        }
    }

    @Override
    public double getTotalFromCart(String name) {
        User user = userRepository.findByname(name);
        Cart cart = cartRepository.findByUser((org.apache.catalina.User) user);

        double total = 0.0;
        if (cart != null) {
            List<Product> products = cart.getProducts();
            for (Product product : products) {
                total += product.getPrix();
            }
        }

        return total;
    }
    }




