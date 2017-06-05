package com.diplom.backend.app;

import com.diplom.backend.user.entity.User;
import com.diplom.backend.user.service.UserService;
import com.diplom.backend.subscription.entity.Subscription;
import com.diplom.backend.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class DBInit {

    @Autowired
    private UserService userService;

    @Autowired
    private SubscriptionService subscriptionService;

//    @PostConstruct
    public void init(){
        User user = new User();
        user.setUsername("user");
        user.setPassword("password");
        userService.add(user);
        Subscription subscription = new Subscription("person", "hello@hello.com");
        subscription.setUser(user);
        subscriptionService.add(subscription);

        System.out.println(user.getUsername());
    }
}
