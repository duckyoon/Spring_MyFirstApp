package com.junes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password){

        boolean isValidUsernName = username.equalsIgnoreCase("junes");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");

        return isValidUsernName && isValidPassword;
    }
}
