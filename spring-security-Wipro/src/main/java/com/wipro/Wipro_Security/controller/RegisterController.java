package com.wipro.Wipro_Security.controller;

import com.wipro.Wipro_Security.model.Userinfo;
import com.wipro.Wipro_Security.repository.UserRepository;
import com.wipro.Wipro_Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class RegisterController {

    @Autowired
    private UserRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public Userinfo createUser(@RequestBody Userinfo user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user) ;
    }
}
