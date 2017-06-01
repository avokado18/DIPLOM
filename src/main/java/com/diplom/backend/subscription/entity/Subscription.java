package com.diplom.backend.subscription.entity;

import com.diplom.backend.user.entity.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subscription")
public class Subscription {

    @Id
    private long id;

    @DBRef
    private User user;

    private String tag;

    private String email;

    public Subscription() {
    }

    public Subscription(User user, String tag, String email) {
        this.user = user;
        this.tag = tag;
        this.email = email;
    }

    public Subscription(String tag, String email) {
        this.tag = tag;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
