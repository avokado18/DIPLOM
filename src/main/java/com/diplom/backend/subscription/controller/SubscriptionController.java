package com.diplom.backend.subscription.controller;

import com.diplom.backend.subscription.model.Subscription;
import com.diplom.backend.subscription.repository.SubscriptionRepository;
import com.diplom.backend.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping("/list")
    public List<Subscription> findAll(){
        return subscriptionService.findAll();
    }
}
