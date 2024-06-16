package com.sesame.projectpdl.Repository;

import com.sesame.projectpdl.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByname(String name);
}
