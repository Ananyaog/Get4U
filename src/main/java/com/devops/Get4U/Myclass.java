package com.devops.Get4U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Myclass 
{
 @GetMapping("hello")
 public String Class() 
 {
     return ("Hello there !");
 }
}
