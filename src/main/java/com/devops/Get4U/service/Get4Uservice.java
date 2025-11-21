package com.devops.Get4U.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devops.Get4U.entity.Get4Uentry;
import com.devops.Get4U.repository.Get4Urepo;

@Component
public class Get4Uservice 
{
    @Autowired
    private Get4Urepo repo;

    public void saveentry(Get4Uentry entry)
    {
        repo.save(entry);
    }
}
