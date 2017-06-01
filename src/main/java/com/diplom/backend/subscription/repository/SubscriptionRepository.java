package com.diplom.backend.subscription.repository;

import com.diplom.backend.security.entity.User;
import com.diplom.backend.subscription.model.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, Long> {

//    @Query(value = "{ 'user.id' : ?0 }")
//    List<Subscription> findByUserId(Long id);

    List<Subscription> findByUser(User user);

    List<Subscription> findByTag(String tag);
}
