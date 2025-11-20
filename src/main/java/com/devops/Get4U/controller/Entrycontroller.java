package com.devops.Get4U.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devops.Get4U.entity.Get4Uentry;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/entry")
public class Entrycontroller 
{
    private Map<Long,Get4Uentry> entries=new HashMap<>();

    @GetMapping // localhost:8080/entry (GET)
    public List<Get4Uentry> getAllEntries()
    {
       return new ArrayList<>(entries.values());
    }

    @PostMapping    // localhost:8080/entry (POST)
    public boolean createEntry(@RequestBody Get4Uentry identifier)
    {
        entries.put(identifier.getId(), identifier);
        return true;
    }

    @GetMapping("id/{myId}")  // localhost:8080/entry/id/"Write desired ID" (GET)
    public Get4Uentry callbyid(@PathVariable long myId)
    {
       return entries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public boolean deletentry(@PathVariable long myId) {
        return entries.remove(myId)!=null;
    }

    @PutMapping("id/{myId}")
    public Get4Uentry putMethodName(@PathVariable long myId, @RequestBody Get4Uentry identifier) 
    {
        //TODO: process PUT request
        
        return entries.put(myId,identifier);
    }
    
}
