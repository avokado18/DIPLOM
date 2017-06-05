package com.diplom.backend.security;


import com.diplom.backend.user.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserManagerImpl implements UserManager {

    @Override
    public User getCurrentUser() {
        Object authObject = SecurityContextHolder.getContext().getAuthentication();

        if(authObject instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authObject;
            if (auth != null && auth.getDetails() instanceof User) {
                return (User) auth.getDetails();
            }
        }
        return null;
    }

}