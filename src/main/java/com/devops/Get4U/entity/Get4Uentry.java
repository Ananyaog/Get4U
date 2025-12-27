package com.devops.Get4U.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Get4Uentries")
public class Get4Uentry
{
    @Id
    private ObjectId id;
    private String title;    
    private String content;
    private LocalDateTime date;

    public void setId(ObjectId id) {
        this.id = id;
    }
    public ObjectId getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public LocalDateTime getDate() {
        return date;
    }

}
