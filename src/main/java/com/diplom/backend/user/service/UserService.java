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

    public User addUser(User user){
        if (userRepository.findByUsername(user.getUsername()) == null){
            User newUser = new User(user.getUsername(), user.getPassword(), user.getEnabled());
            return userRepository.save(newUser);
        }
        else return null;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }


}
