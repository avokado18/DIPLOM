package com.diplom.backend.app;

import com.diplom.backend.security.entity.User;
import com.diplom.backend.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DBInit {
    @Autowired
    private UserService userService;

    @Autowired
    MongoTemplate mongoTemplate;

    @PostConstruct
    @Transactional
    public void init(){
        mongoTemplate.getDb().dropDatabase();
        User user = new User();
        user.setUsername("user");
        user.setPassword("password");
        user.setEnabled((byte) 1);
        userService.addUser(user);
        System.out.println(user.getUsername());
    }
}
