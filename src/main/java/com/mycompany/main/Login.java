package com.mycompany.main;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Login {
    private final Map<String, String> userDatabase = new HashMap<>();
    private boolean loggedIn = false;

    public void registerUser(String username, String password, String firstName, String lastName) {
        
        if (validateUsername(username) && validatePassword(password)) {
            userDatabase.put(username, password); 
            loggedIn = false; 
        } else {
            throw new IllegalArgumentException("Invalid username or password format.");
        }
    }

    public boolean loginUser(String username, String password) {
        
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            loggedIn = true;
            return true; 
        }
        return false; 
    }

    public boolean isLoggedIn() {
        return loggedIn; 
    }

    
    public boolean validateUsername(String username) {
        return username.length() >= 3 && Pattern.matches("^[a-zA-Z0-9_]+$", username);
    }

    
    public boolean validatePassword(String password) {
        return password.length() >= 8 && 
               Pattern.compile("[A-Z]").matcher(password).find() && 
               Pattern.compile("[a-z]").matcher(password).find() && 
               Pattern.compile("[0-9]").matcher(password).find() && 
               Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }
}
