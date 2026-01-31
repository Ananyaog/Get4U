package com.devops.Get4U.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devops.Get4U.entity.Get4Uentry;
import com.devops.Get4U.entity.User;
import com.devops.Get4U.service.Get4Uservice;
import com.devops.Get4U.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/user")
public class Usercontroller
{
    @Autowired
    private UserService userService;

    @GetMapping // localhost:8080/user (GET)
    public  List<User> getallUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping    // localhost:8080/user (POST)
    public void saveUser(@RequestBody User user)  // Save user function
    {
        userService.saveUser(user);
    }


    @PutMapping
    public ResponseEntity<?> updateuser(@RequestBody User user) {
      User userinDB= userService.findByUsername(user.getUsername());
      if(userinDB!=null)
      {
        userinDB.setPassword(user.getPassword());
        userinDB.setUsername(user.getUsername());
        userService.saveUser(userinDB);
      }
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
