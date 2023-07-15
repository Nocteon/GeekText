package com.example.geektext.CreditCardStuff;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    CreditCard findByUsername(String username);

}
