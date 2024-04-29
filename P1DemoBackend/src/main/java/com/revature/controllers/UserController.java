package com.revature.controllers;

import com.revature.models.DTOs.IncomingUserDTO;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000") //approving our frontend to talk to this controller
public class UserController {

    //autowire user service
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<String> registerUser(@RequestBody IncomingUserDTO userDTO){

        //try to register the user
        try{
            userService.registerUser(userDTO);
            return ResponseEntity.status(201).body(userDTO.getUsername() + " was created!");
            //If this all works, send back a 201 CREATED, plus a confirmation message
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(400).body(e.getMessage());
            //If something goes wrong, send back a 400 BAD REQUEST, plus the error message
        }
        //TODO: We'll have checks for DB issues here as well

    }

}
