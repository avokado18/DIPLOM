package com.diplom.backend.subscription.service;

import com.diplom.backend.user.entity.User;
import com.diplom.backend.subscription.entity.Subscription;
import com.diplom.backend.subscription.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Transactional
    public List<Subscription> findAll(){
        return subscriptionRepository.findAll();
    }

    @Transactional
    public List<Subscription> findByTag(String tag){
        return subscriptionRepository.findByTag(tag);
    }

    @Transactional
    public List<Subscription> findByUser(User user){
        return subscriptionRepository.findByUser(user);
    }

//    @Transactional
//    public List<Subscription> findByUserId(Long id){
//        return subscriptionRepository.findByUserId(id);
//    }

    @Transactional
    public void delete(Long id){
        subscriptionRepository.delete(id);
    }

    @Transactional
    public Subscription add(User user, Subscription subscription){
        Subscription newSubscription = new Subscription();
        newSubscription.setTag(subscription.getTag());
        newSubscription.setEmail(subscription.getEmail());
        newSubscription.setUser(user);
        return subscriptionRepository.save(newSubscription);
    }

    @Transactional
    public Subscription update(Long id, Subscription subscription){
        Subscription newSubscription = subscriptionRepository.findOne(id);
        newSubscription.setEmail(subscription.getEmail());
        newSubscription.setTag(subscription.getTag());
        newSubscription.setUser(subscription.getUser());
        return subscriptionRepository.save(subscription);
    }
}
