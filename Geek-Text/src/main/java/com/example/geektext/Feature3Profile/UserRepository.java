package com.example.geektext.Feature3Profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<com.example.geektext.Feature3Profile.User, Long> {
    com.example.geektext.Feature3Profile.User findByUsername(String username);

}
