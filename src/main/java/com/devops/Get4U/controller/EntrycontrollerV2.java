package com.devops.Get4U.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/entry")
public class EntrycontrollerV2
{
    @Autowired
    private Get4Uservice service;
    @Autowired
    private UserService userService;

    @GetMapping("{username}") // localhost:8080/entry/{username} (GET)
    public ResponseEntity<?> getAllEntriesOfuser(@PathVariable String username)
    {  
    User user = userService.findByUsername(username); // Finds if username exists
     if(user == null) {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
        List <Get4Uentry> all = user.getGet4uentries();
        if(all!=null && !all.isEmpty())
        {
            return new ResponseEntity<>(all,HttpStatus.OK);
        } 
        
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("{username}")    // localhost:8080/entry (POST)
    public ResponseEntity<Get4Uentry> createEntry(@RequestBody Get4Uentry identifier,@PathVariable String username)
    {
        try{
             identifier.setDate(LocalDateTime.now());
             service.saveentry(identifier,username); 
            return new ResponseEntity<>(identifier, HttpStatus.CREATED);
             }
         catch(Exception e)
         {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }

    }

    @GetMapping("id/{myId}")  // localhost:8080/entry/id/"Write desired ID" (GET)
    public ResponseEntity<Get4Uentry> callbyid(@PathVariable ObjectId myId)
    {
       Optional<Get4Uentry> entry = service.findbyid(myId);
       if(entry.isPresent()) 
       {
        return new ResponseEntity<>(entry.get(),HttpStatus.OK);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{username}/{myId}")  // Deletes the entry of {username} completely from User's collections
    public ResponseEntity<?> deletentry(@PathVariable ObjectId myId,@PathVariable String username)
     {
        service.deletebyid(myId,username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

     @PutMapping("id/{username}/{id}") // Bugged
     public ResponseEntity<?> UpdateEntrybyid(@PathVariable ObjectId id, @RequestBody Get4Uentry new_entry,@PathVariable String username) 
     {
         Get4Uentry old=new Get4Uservice().findbyid(id).orElse(null);

         if(old!=null)
         {
            old.setTitle(new_entry.getTitle()!=null && !new_entry.getTitle().equals("")?new_entry.getTitle():old.getTitle());
            
            old.setContent(new_entry.getContent()!=null && !new_entry.getContent().equals("")?new_entry.getContent():old.getContent());
            
         return new ResponseEntity<>(old,HttpStatus.OK);
        }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
    
}
