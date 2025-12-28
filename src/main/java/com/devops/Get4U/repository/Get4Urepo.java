package com.devops.Get4U.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.devops.Get4U.entity.Get4Uentry;

public interface Get4Urepo extends MongoRepository<Get4Uentry,ObjectId>
{
    
} 
