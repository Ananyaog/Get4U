package com.devops.Get4U.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import com.devops.Get4U.entity.User;
import java.util.Optional;
import com.devops.Get4U.repository.userRepo;


@Component
public class UserService 
{
    @Autowired
    private userRepo userRepository;  

    public void saveUser(User user)  // Save user function
    {
        userRepository.save(user);
    }

    public List<User> getAllUsers()  // Get all users function
    {
        return userRepo.findAll();
    }

    public Optional<User> findUserById (ObjectId id)  // Find user by ID function
    {
        return userRepo.findById(id);
    }

}
