package com.official.user.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.official.user.login.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public User findByUsernameAndPassword(String username, String password);
}
