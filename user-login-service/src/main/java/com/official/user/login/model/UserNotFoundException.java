package com.official.user.login.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    private String message;

    public UserNotFoundException(String message) {

        super(message);
        this.setMessage(message);
    }

}
