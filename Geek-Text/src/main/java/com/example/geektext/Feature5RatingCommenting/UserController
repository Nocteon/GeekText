package com.geektext.app.rest.Controllers;

import com.geektext.app.rest.Models.User;
import com.geektext.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage()
    {
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers()
    {
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user)
    {
        userRepo.save(user);
        return "Saved...";
    }
}
