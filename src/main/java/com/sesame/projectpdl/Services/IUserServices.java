package com.sesame.projectpdl.Services;

import com.sesame.projectpdl.Entity.User;

public interface IUserServices {
    public User registerUser(User user);
    public Boolean Authentification(String name,String password);

}
