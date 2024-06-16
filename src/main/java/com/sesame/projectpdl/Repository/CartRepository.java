package com.sesame.projectpdl.Repository;

import com.sesame.projectpdl.Entity.Cart;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {



    Cart findByUser(User user);
}
