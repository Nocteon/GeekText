package com.example.geektext.Feature3Profile;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    private final com.example.geektext.Feature3Profile.UserRepository userRepository;

    @Autowired
    public UserService(com.example.geektext.Feature3Profile.UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
