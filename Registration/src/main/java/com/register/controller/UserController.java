package com.register.controller;

import com.register.entity.User;
import com.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerRetailer"}) 
    public User registerNewUser(@RequestBody User user) {     
        return userService.registerNewUser(user);           
    }
    
    @PostMapping({"/registerDistributor"})          //Distributor
    public User registerDistributor(@RequestBody User user) {     
        return userService.registerDistributor(user);           
    }
    
    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){  
        return "This URL is accessible to the admin";
    }

    @GetMapping({"/forRetailer"})             //forUser
    @PreAuthorize("hasRole('Retailer')")        //User
    public String forUser(){
        return "This URL is accessible to the retailer";
    }
    @GetMapping({"/forDistributor"})             
    @PreAuthorize("hasRole('Distributor')")        //Distributor
    public String forDistributor(){
        return "This URL is accessible to the Distributor";
    }
  
    
}

