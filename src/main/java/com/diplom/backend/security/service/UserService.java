package com.diplom.backend.security.service;

import com.diplom.backend.security.entity.User;
import com.diplom.backend.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User addUser(User user){
        if (userRepository.findByUsername(user.getUsername()) == null){
            User newUser = new User(user.getUsername(), user.getPassword(), user.getEnabled());
            return userRepository.save(newUser);
        }
        else return null;
    }

    @Transactional
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUser(User user){
        userRepository.delete(user);
    }


}
