package com.diplom.backend.subscription.service;

import com.diplom.backend.user.entity.User;
import com.diplom.backend.subscription.entity.Subscription;
import com.diplom.backend.subscription.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Subscription> findAll(){
        return subscriptionRepository.findAll();
    }

    public List<Subscription> findByTag(String tag){
        return subscriptionRepository.findByTag(tag);
    }

    public Subscription findById(BigInteger id){
        return subscriptionRepository.findById(id);
    }

    public List<Subscription> findByUser(User user){
        return subscriptionRepository.findByUser(user);
    }

    public List<Subscription> findByUserId(BigInteger id){
        return subscriptionRepository.findByUserId(id);
    }

    public void delete(BigInteger id){
        subscriptionRepository.delete(id);
    }

    public void delete(Subscription subscription){
        subscriptionRepository.delete(subscription);
    }

    public Subscription add(User user, Subscription subscription){
        Subscription newSubscription = new Subscription();
        newSubscription.setTag(subscription.getTag());
        newSubscription.setEmail(subscription.getEmail());
        newSubscription.setUser(user);
        return subscriptionRepository.save(newSubscription);
    }

    public Subscription update(BigInteger id, Subscription subscription){
        Subscription newSubscription = subscriptionRepository.findOne(id);
        newSubscription.setEmail(subscription.getEmail());
        newSubscription.setTag(subscription.getTag());
        newSubscription.setUser(subscription.getUser());
        return subscriptionRepository.save(subscription);
    }
}
