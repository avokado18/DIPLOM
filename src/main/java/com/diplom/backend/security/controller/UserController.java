package com.diplom.backend.security.controller;

import com.diplom.backend.security.entity.User;
import com.diplom.backend.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path="/list", method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.findAll();
    }
}
