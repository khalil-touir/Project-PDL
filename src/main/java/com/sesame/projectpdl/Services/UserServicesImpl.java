package com.sesame.projectpdl.Services;

import com.sesame.projectpdl.Entity.User;
import com.sesame.projectpdl.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServicesImpl implements IUserServices {
UserRepository userRepository;
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean Authentification(String name, String password) {
        List<User> c= (List<User>) userRepository.findAll();
        for(User u:c){
            if(u.getName().equals(name) && u.getPassword().equals(password)){
                return true;
            }
        }
        return false;

    }
}