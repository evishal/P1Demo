package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service Classes are used for data processing between controllers and DAOs
//anything we need to do between HTTP and the Database is done here
    //Error handling
    //Data mutations
    //Data validations
    //more!

@Service
public class UserService {

    //autowire the UserDAO
    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //register user
    public User registerUser(){
        return null;
    }

}
