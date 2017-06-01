package com.diplom.backend.subscription.repository;

import com.diplom.backend.user.entity.User;
import com.diplom.backend.subscription.entity.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, Long> {

    @Query(value = "{ 'user.id' : ?0 }")
    List<Subscription> findByUserId(long id);

    List<Subscription> findByUser(User user);

    List<Subscription> findByTag(String tag);
}
