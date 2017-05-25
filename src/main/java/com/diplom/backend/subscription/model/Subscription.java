package com.diplom.backend.subscription.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subscription")
public class Subscription {

    @Id
    private long id;

    private long userId;

    private String tag;

    private String email;

    public Subscription() {
    }

    public Subscription(long userId, String tag, String email) {
        this.userId = userId;
        this.tag = tag;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
