package com.devops.Get4U.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.devops.Get4U.entity.User;

public interface userRepo extends MongoRepository<User,ObjectId>
{
    User findByUsername(String username);
} 
