package com.twu.biblioteca;

public class User {

    private String user;
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUsername() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }
}
