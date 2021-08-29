package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){

        return userService.addUser(user);
    }

    @GetMapping("/user/{name}")
    public User getUser(@PathVariable String name){

        return userService.retrieveUser(name);
    }

    @GetMapping("/user")
    public List<User> getAll(){

        return userService.getAll();
    }
}
