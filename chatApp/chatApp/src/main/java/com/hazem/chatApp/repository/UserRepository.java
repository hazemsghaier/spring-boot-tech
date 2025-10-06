package com.hazem.chatApp.repository;

import com.hazem.chatApp.entity.User;
import com.hazem.chatApp.entity.UserStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(UserStatus status);

}
