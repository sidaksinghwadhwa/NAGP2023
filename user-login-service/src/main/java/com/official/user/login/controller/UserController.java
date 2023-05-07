package com.official.user.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.official.user.login.config.AuthConfig;
import com.official.user.login.model.User;
import com.official.user.login.model.UserNotFoundException;
import com.official.user.login.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthConfig authConfig;

    @PostMapping("/sign-up")
    public ResponseEntity<?> postUser(@RequestBody User user) {

        try {
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> loginUser(@RequestBody User user) {

        try {
            if (user.getUsername() == null || user.getPassword() == null) {
                throw new UserNotFoundException("Blank Username and Password");
            }
            User userData = userService.getUserByNameAndPassword(user.getUsername(),
                    user.getPassword());
            if (userData == null) {
                throw new UserNotFoundException("Incorrect Credentials");
            }
            return new ResponseEntity<>(authConfig.authToken(user), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
