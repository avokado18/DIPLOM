package com.diplom.backend.user.repository;

import com.diplom.backend.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository extends MongoRepository<User, BigInteger> {
    User findByUsername(String username);
}
