package com.sesame.projectpdl.Services;

import com.sesame.projectpdl.Entity.Cart;

public interface ICarteServices {
    public Cart getCartByUser(String name);
    public void addProductToCart(String name, Long Id);
    public void removeProductFromCart(String name, Long Id);
    public double getTotalFromCart(String name);
}
