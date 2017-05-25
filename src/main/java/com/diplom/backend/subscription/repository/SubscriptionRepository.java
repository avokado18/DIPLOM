package com.diplom.backend.subscription.repository;

import com.diplom.backend.subscription.model.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, Long> {

    List<Subscription> findByUserId(long id);

    List<Subscription> findByTag(String tag);
}
