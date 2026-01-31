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
import com.devops.Get4U.service.Get4Uservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/entry")
public class EntrycontrollerV2
{
    @Autowired
    private Get4Uservice service;

    @GetMapping // localhost:8080/entry (GET)
    public ResponseEntity<List<Get4Uentry>> getAllEntries()
    {
        List <Get4Uentry> all = new ArrayList<>();
        if(all!=null && !all.isEmpty())
        {
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        
     return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping    // localhost:8080/entry (POST)
    public ResponseEntity<Get4Uentry> createEntry(@RequestBody Get4Uentry identifier)
    {
        try{
             identifier.setDate(LocalDateTime.now());
             service.saveentry(identifier);
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

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deletentry(@PathVariable ObjectId myId)
     {
        service.deletebyid(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> putMethodName(@PathVariable ObjectId myId, @RequestBody Get4Uentry new_identifier) 
    {
        
       Get4Uentry existing_identifier=service.findbyid(myId).orElse(null);
       if(existing_identifier != null)
       {
        existing_identifier.setTitle(new_identifier !=null && !new_identifier.getTitle().equals("") ? new_identifier.getTitle():existing_identifier.getTitle());
        existing_identifier.setContent(new_identifier !=null && !new_identifier.getContent().equals("") ? new_identifier.getContent():existing_identifier.getContent());
         service.saveentry(existing_identifier);
        return new ResponseEntity<>(existing_identifier,HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
