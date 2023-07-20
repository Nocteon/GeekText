package com.example.geektext.Feature3Profile;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CreditCardService {

    private final com.example.geektext.Feature3Profile.CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardService(com.example.geektext.Feature3Profile.CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

}
