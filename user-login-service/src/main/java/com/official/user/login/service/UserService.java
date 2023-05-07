package com.official.user.login.service;

import org.springframework.stereotype.Service;

import com.official.user.login.model.User;
import com.official.user.login.model.UserNotFoundException;

@Service
public interface UserService {

    public void saveUser(User user);

    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}
