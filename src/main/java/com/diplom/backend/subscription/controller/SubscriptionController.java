package com.diplom.backend.subscription.controller;

import com.diplom.backend.subscription.entity.Subscription;
import com.diplom.backend.subscription.service.SubscriptionService;
import com.diplom.backend.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/private_office")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping("/list")
    public List<Subscription> findAll(){
        return subscriptionService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAllForCurrentUser(User user, ModelMap modelMap){
        modelMap.addAttribute("subscriptions", subscriptionService.findAll());
        return "privateOffice/subscriptionListForUser";
    }
}
