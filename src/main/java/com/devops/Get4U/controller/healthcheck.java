package com.devops.Get4U.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class healthcheck
{
    @GetMapping("/health") // Endpoint to check application health
    public String life() 
    {
        return "Get4U is up and running!";
    }
}
