package com.official.user.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.user.login.model.User;
import com.official.user.login.model.UserNotFoundException;
import com.official.user.login.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {

        userRepository.save(user);
    }

    @Override
    public User getUserByNameAndPassword(String name, String password)
            throws UserNotFoundException {

        User user = userRepository.findByUsernameAndPassword(name, password);
        if (user == null) {
            throw new UserNotFoundException("Incorrect Credentials");
        }
        return user;
    }
}
