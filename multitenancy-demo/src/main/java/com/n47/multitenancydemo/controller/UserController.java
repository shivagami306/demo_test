package com.n47.multitenancydemo.controller;

import com.n47.multitenancydemo.domain.UserDomain;
import com.n47.multitenancydemo.domain.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public UserDomain addUser(@RequestBody UserRequestBody userRequestBody) {
        UserDomain userDomain = new UserDomain(userRequestBody.getName());
        return userRepository.save(userDomain);
    }

    @GetMapping
    public List<UserDomain> getAll() {
        return userRepository.findAll();
    }
    
    @GetMapping
    public String test() {
        return "sampleTest";
    }
}
