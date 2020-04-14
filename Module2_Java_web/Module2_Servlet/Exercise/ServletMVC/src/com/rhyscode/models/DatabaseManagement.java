package com.rhyscode.models;

public class DatabaseManagement {
    public boolean checkUser(String username,String password) {
        if (username.equals(username) && password.equals("admin"))
            return true;
        return false;
    }
}
