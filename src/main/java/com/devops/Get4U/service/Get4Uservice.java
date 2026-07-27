package com.devops.Get4U.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import com.devops.Get4U.entity.Get4Uentry;
import com.devops.Get4U.entity.User;
import com.devops.Get4U.repository.Get4Urepo;
import java.util.Optional;

@Component
public class Get4Uservice 
{
    @Autowired
    private Get4Urepo repo;  

    @Autowired
    private UserService userService;

    public void saveentry(Get4Uentry entry)  // Save entry function
    {
       repo.save(entry); // Saved in Get4U
    }

        public void saveentry(Get4Uentry entry, String username)  // Save entry function (Handles PUT requests)
    {
        User user = userService.findByUsername(username);
        Get4Uentry saved=repo.save(entry); // Saved in Get4U

        user.getGet4uentries().add(saved); // Saving in User's Field
        userService.saveUser(user);
    }


    public List<Get4Uentry> getall()  // Get all entries function
    {
        return repo.findAll();
    }

    public Optional<Get4Uentry> findbyid (ObjectId id)  // Find by ID function
    {
        return repo.findById(id);
    }

    public void deletebyid(ObjectId id,String username)  // Delete function
    {
        User user = userService.findByUsername(username);
        user.getGet4uentries().removeIf(x -> x.getId().equals(id));
        userService.saveUser(user); // Saves new updated entries (After deleteing the Get4U entry)

        repo.deleteById(id); // Deletes Get4U entry
    }

}
