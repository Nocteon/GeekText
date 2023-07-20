package com.example.geektext.Feature3Profile;

import com.example.geektext.Feature3Profile.CreditCard;
import com.example.geektext.Feature3Profile.CreditCardRepository;
import com.example.geektext.Feature3Profile.User;
import com.example.geektext.Feature3Profile.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/creditcards")
    public List<CreditCard> getCreditCards() {
        return creditCardRepository.findAll();
    }

    @GetMapping(value = "users/{username}")
    public User getUser(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @GetMapping(value = "creditcards/{username}")
    public CreditCard getCreditCard(@PathVariable String username) {
        return creditCardRepository.findByUsername(username);
    }

    @PostMapping(value = "/saveuser")
    public String saveUser(@RequestBody User user) {
        userRepository.save(user);
        return "Saved";
    }

    @PostMapping(value = "/savecreditcard/{username}")
    public String saveCreditCard(@PathVariable String username, @RequestBody CreditCard creditCard) {
        creditCard.setUsername(username);
        creditCardRepository.save(creditCard);
        return "Saved";
    }

    @PutMapping(value = "updateuser/{username}")
    public String updateUser(@PathVariable String username, @RequestBody User updateUser) {
        User existingUser = userRepository.findByUsername(username);
        CreditCard existingCard = creditCardRepository.findByUsername(username);

        if (updateUser.getUsername() != null) {
            existingUser.setUsername(updateUser.getUsername());
            if (existingCard != null) {
                existingCard.setUsername(updateUser.getUsername());
            }
        }
        if (updateUser.getPassword() != null) {
            existingUser.setPassword(updateUser.getPassword());
        }
        if (updateUser.getName() != null) {
            existingUser.setName(updateUser.getName());
            if (existingCard != null) {
                existingCard.setName(updateUser.getName());
            }
        }
        if (updateUser.getAddress() != null) {
            existingUser.setAddress(updateUser.getAddress());
        }

        userRepository.save(existingUser);
        if (existingCard != null) {
            creditCardRepository.save(existingCard);
        }

        return "Updated";
    }

    @DeleteMapping(value = "deleteuser/{username}")
    public String deleteUser(@PathVariable String username) {
        User deleteUser = userRepository.findByUsername(username);
        CreditCard deleteCard = creditCardRepository.findByUsername(username);

        if (deleteCard != null) {
            creditCardRepository.delete(deleteCard);
        }
        userRepository.delete(deleteUser);

        return "Deleted";
    }

}
