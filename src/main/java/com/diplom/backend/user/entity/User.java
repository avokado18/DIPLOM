package com.diplom.backend.user.entity;

import com.diplom.backend.subscription.entity.Subscription;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user")
public class User {

    @Id
    private long id;

    @Indexed(unique = true)
    private String username;

    private String password;

    private Byte enabled;

    @DBRef
    private List<Subscription> subscriptions;

    public User(User user) {
        this.username = user.username;
        this.password = user.password;
        this.enabled = user.enabled;
    }

    public User(String username, String password, byte enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
