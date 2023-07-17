package com.example.geektext.Feature2.CreditCardStuff;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<com.example.geektext.Feature2.CreditCardStuff.CreditCard, Long> {
    com.example.geektext.Feature2.CreditCardStuff.CreditCard findByUsername(String username);

}
