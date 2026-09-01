package com.devops.Get4U.entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Document(collection="users")
@Data
public class User
{
    @Id
    private ObjectId id;
    @Indexed (unique=true)
    @NonNull  // From lombok
    private String username;
    @NonNull
    private String password;

    @DBRef  // Creating reference in 'users' collection from 'get4uentries' collection (Act like foreign key principles i.e linking 2 existing collection)
    private List<Get4Uentry> get4uentries=new ArrayList<>();
    private List<String> roles;

}
