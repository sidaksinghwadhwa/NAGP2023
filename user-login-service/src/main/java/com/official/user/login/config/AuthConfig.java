package com.official.user.login.config;

import java.util.Map;

import com.official.user.login.model.User;

public interface AuthConfig {

    Map<String, String> authToken(User user);
}
