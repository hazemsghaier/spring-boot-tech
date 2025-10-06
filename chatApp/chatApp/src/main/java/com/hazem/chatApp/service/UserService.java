package com.hazem.chatApp.service;

import com.hazem.chatApp.entity.User;
import com.hazem.chatApp.entity.UserStatus;
import com.hazem.chatApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void save(User user) {
        user.setStatus(UserStatus.ONLINE);
        userRepository.save(user);

    }
    public void disconnectUser(User user) {

    }
    public List<User> findConectedUsers() {
        return null;
    }

}
