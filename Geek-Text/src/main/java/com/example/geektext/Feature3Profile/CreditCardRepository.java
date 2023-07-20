package com.example.geektext.Feature3Profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<com.example.geektext.Feature3Profile.CreditCard, Long> {
    com.example.geektext.Feature3Profile.CreditCard findByUsername(String username);

}
