package com.diplom.backend.user.controller;

import com.diplom.backend.security.UserManager;
import com.diplom.backend.subscription.entity.Subscription;
import com.diplom.backend.subscription.service.SubscriptionService;
import com.diplom.backend.user.entity.User;
import com.diplom.backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private UserManager userManager;

    @RequestMapping(path="/registration", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user){
        user.setUsername(user.getUsername().trim());
        user.setPassword(user.getPassword().trim());
        if (userService.userExists(user)){
            Map<String, Object> params = new HashMap();
            params.put("error", "Пользователь с таким именем уже существует, попробуйте еще раз!");
            return new ModelAndView("registration", params);
        }
        if (user.getUsername().equals("") || user.getPassword().equals("")){
            Map<String, Object> params = new HashMap();
            params.put("error", "Недопустимые значения");
            return new ModelAndView("registration", params);
        }
        if (user.getPassword().length() < 8){
            Map<String, Object> params = new HashMap();
            params.put("error", "Пароль должен содержать не меньше 8 символов");
            return new ModelAndView("registration", params);
        }
        else {
            userService.add(user);
            Map<String, Object> params = new HashMap();
            params.put("message", "Вы успешно зарегистрировались, осуществите вход!");
            return new ModelAndView("login", params);
        }
    }

    @RequestMapping(path="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        Map<String, Object> params = new HashMap();
        params.put("error", "");
        return new ModelAndView("registration", params);
    }

    @RequestMapping(path="/users", method = RequestMethod.GET)
    public List<User> listUsers(){
        return userService.findAll();
    }

    @RequestMapping(path="/currentUser", method = RequestMethod.GET)
    public User getCurrentUser(){
        return userManager.getCurrentUser();
    }

    @RequestMapping(path="/login", method = RequestMethod.GET)
    public ModelAndView redirectToSubscriptions(){
        if (userManager.getCurrentUser() != null){
            Map<String, Object> params = new HashMap();
            params.put("user", userManager.getCurrentUser());
            params.put("subscriptions", subscriptionService.findByUser(userManager.getCurrentUser()));
            return new ModelAndView("/subscriptions", params);
        }
        return new ModelAndView("login");
    }
}
