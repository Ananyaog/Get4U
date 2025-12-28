package com.devops.Get4U.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import com.devops.Get4U.entity.Get4Uentry;
import com.devops.Get4U.repository.Get4Urepo;
import java.util.Optional;

@Component
public class Get4Uservice 
{
    @Autowired
    private Get4Urepo repo;  

    public void saveentry(Get4Uentry entry)  // Save entry function
    {
        repo.save(entry);
    }

    public List<Get4Uentry> getall()  // Get all entries function
    {
        return repo.findAll();
    }

    public Optional<Get4Uentry> findbyid (ObjectId id)  // Find by ID function
    {
        return repo.findById(id);
    }

    public void deletebyid(ObjectId id)  // Delete function
    {
        repo.deleteById(id);
    }
}
