package com.official.user.login.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.official.user.login.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthConfigImpl implements AuthConfig {

    @Override
    public Map<String, String> authToken(User user) {

        String token = "";
        token = Jwts.builder()// .setExpiration(new Date(System.currentTimeMillis() + 60000))
                .setSubject(user.getUsername()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret").compact();
        Map<String, String> jwtTokenGen = new HashMap<>();
        jwtTokenGen.put("token", token);
        jwtTokenGen.put("message", "Login Successful");
        return jwtTokenGen;
    }

}
