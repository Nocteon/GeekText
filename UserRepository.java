package com.example.geektext.Feature2.UserStuff;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<com.example.geektext.Feature2.UserStuff.User, Long> {
    com.example.geektext.Feature2.UserStuff.User findByUsername(String username);

}
