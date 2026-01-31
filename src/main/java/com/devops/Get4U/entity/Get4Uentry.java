package com.devops.Get4U.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Document(collection="Get4Uentries")
@Data
public class Get4Uentry
{
    @Id
    private ObjectId id;
    @NonNull
    private String title;    
    private String content;
    private LocalDateTime date;
}
