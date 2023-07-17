package com.example.geektext.Feature2.CreditCardStuff;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CreditCardService {

    private final com.example.geektext.Feature2.CreditCardStuff.CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardService(com.example.geektext.Feature2.CreditCardStuff.CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

}
