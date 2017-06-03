package com.diplom.backend.subscription.controller;

import com.diplom.backend.subscription.entity.Subscription;
import com.diplom.backend.subscription.service.SubscriptionService;
import com.diplom.backend.user.entity.User;
import com.diplom.backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<Subscription> findAll(){
        return subscriptionService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView findAllForCurrentUser(){
        List<Subscription> subscriptions = subscriptionService.findAll();
        Map<String, Object> params = new HashMap();
        params.put("subscriptions", subscriptions);
        return new ModelAndView("subscriptions", params);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("subscription") Subscription subscription){
        if (subscription.getId() != null){
            subscriptionService.update(subscription.getId(), subscription);
        } else {
            subscriptionService.add(userService.findByUsername("user"), subscription);
        }
        return new ModelAndView("redirect:/subscriptions");
    }

    @RequestMapping(value = "/add")
    public ModelAndView add(){
        Subscription subscription = new Subscription("", "");
        Map<String, Object> params = new HashMap();
        params.put("subscription", subscription);
        return new ModelAndView("addOrEditSubscription", params);
    }

    private BigInteger stringToBigInt(String str){
        String[] idArr = str.split(Character.toString((char) 160));
        String idWithoutSpaces = String.join("", idArr);
        return new BigInteger(idWithoutSpaces);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public @ResponseBody ModelAndView delete(@PathVariable("id") String id){
        subscriptionService.delete(stringToBigInt(id));
        return new ModelAndView("redirect:/subscriptions");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public @ResponseBody ModelAndView toUpdatePage(@PathVariable("id") String id){
        Subscription subscription = subscriptionService.findById(stringToBigInt(id));
        Map<String, Object> params = new HashMap();
        params.put("subscription", subscription);
        return new ModelAndView("addOrEditSubscription", params);
    }
}
