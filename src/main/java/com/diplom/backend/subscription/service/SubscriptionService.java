package com.diplom.backend.subscription.service;

import com.diplom.backend.security.entity.User;
import com.diplom.backend.subscription.model.Subscription;
import com.diplom.backend.subscription.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Transactional
    public List<Subscription> findByUser(User user){
        long userId = user.getId();
        return subscriptionRepository.findByUserId(userId);
    }

    @Transactional
    public List<Subscription> findByTag(String tag){
        return subscriptionRepository.findByTag(tag);
    }

    @Transactional
    public void delere(Long id){
        subscriptionRepository.delete(id);
    }

    @Transactional
    public Subscription add(User user, Subscription subscription){
        Subscription newSubscription = new Subscription();
        newSubscription.setTag(subscription.getTag());
        newSubscription.setEmail(subscription.getEmail());
        newSubscription.setUserId(user.getId());
        return subscriptionRepository.save(newSubscription);
    }

    @Transactional
    public Subscription update(Long id, Subscription subscription){
        Subscription newSubscription = subscriptionRepository.findOne(id);
        newSubscription.setEmail(subscription.getEmail());
        newSubscription.setTag(subscription.getTag());
        newSubscription.setUserId(subscription.getUserId());
        return subscriptionRepository.save(subscription);
    }
}
