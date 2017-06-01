package com.diplom.backend.app;

import com.diplom.backend.user.entity.User;
import com.diplom.backend.user.service.UserService;
import com.diplom.backend.subscription.entity.Subscription;
import com.diplom.backend.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

//@Component
public class DBInit {
    @Autowired
    private UserService userService;

    @Autowired
    private SubscriptionService subscriptionService;

//    @PostConstruct
//    @Transactional
    public void init(){
        User user = new User();
        user.setUsername("user");
        user.setPassword("password");
        user.setEnabled((byte) 1);
        userService.addUser(user);
        Subscription subscription = new Subscription("person", "hello@hello.com");
        subscriptionService.add(user, subscription);

        System.out.println(user.getUsername());
    }
}
