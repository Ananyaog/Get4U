package com.devops.Get4U.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(collection="Get4Uentries")
@Getter
@Setter
public class Get4Uentry
{
    @Id
    private ObjectId id;
    private String title;    
    private String content;
    private LocalDateTime date;
}
