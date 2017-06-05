package com.diplom.backend.user.service;

import com.diplom.backend.user.entity.User;
import com.diplom.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User add(User user){
        User newUser = new User(user.getUsername(), user.getPassword());
        return userRepository.save(newUser);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public boolean userExists(User user){
        return userRepository.findByUsername(user.getUsername()) != null;
    }


}
