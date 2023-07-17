package com.example.geektext.Feature2.UserStuff;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    private final com.example.geektext.Feature2.UserStuff.UserRepository userRepository;

    @Autowired
    public UserService(com.example.geektext.Feature2.UserStuff.UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
