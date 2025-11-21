package com.devops.Get4U.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
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
    public List<Get4Uentry> getAllEntries()
    {
     return null;
    }

    @PostMapping    // localhost:8080/entry (POST)
    public boolean createEntry(@RequestBody Get4Uentry identifier)
    {
        service.saveentry(identifier);
        return true;
    }

    @GetMapping("id/{myId}")  // localhost:8080/entry/id/"Write desired ID" (GET)
    public Get4Uentry callbyid(@PathVariable long myId)
    {
     
     return null;
    }

    @DeleteMapping("id/{myId}")
    public boolean deletentry(@PathVariable long myId) {
        
     return true;
    }

    @PutMapping("id/{myId}")
    public Get4Uentry putMethodName(@PathVariable long myId, @RequestBody Get4Uentry identifier) 
    {
        //TODO: process PUT request
        
        
     return null;
    }
    
}
