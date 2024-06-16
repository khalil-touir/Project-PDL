package com.sesame.projectpdl.Controller;

import com.sesame.projectpdl.Entity.Cart;
import com.sesame.projectpdl.Services.CartServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartServicesImpl cartServices;
    @GetMapping("/{name}/totalpanier")
    public double getTotalFromCart(@PathVariable String name) {
        return cartServices.getTotalFromCart(name);
    }
    @GetMapping("/{name}/panier")
    public Cart getCartByUsername(@PathVariable String name) {
        return cartServices.getCartByUser(name);
    }
    @PostMapping("/{name}/add/{productId}")
    public void addProductToCart(@PathVariable String name, @PathVariable Long Id) {
        cartServices.addProductToCart(name, Id);
    }
    @DeleteMapping("/{name}/remove/{productId}")
    public void removeProductFromCart(@PathVariable String name, @PathVariable Long Id) {
        cartServices.removeProductFromCart(name,Id);
    }
}