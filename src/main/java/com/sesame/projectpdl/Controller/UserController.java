package com.sesame.projectpdl.Controller;

import com.sesame.projectpdl.Entity.User;
import com.sesame.projectpdl.Services.UserServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserServicesImpl userServices;
    @PostMapping("/Register")
    public User registerUser(@RequestBody User user){
        return userServices.registerUser(user);
    }
    @GetMapping("/login/{name}/{password}")
    public Boolean Authentification(@PathVariable("name") String name,@PathVariable("password") String password){
        return userServices.Authentification(name,password);
    }
}

