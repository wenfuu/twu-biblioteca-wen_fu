package com.twu.biblioteca;

public class User {

    private String user;
    private String password;
    private String name;
    private String email;
    private String number;

    public User(String user, String password, String name, String email, String number) {
        this.user = user;
        this.password = password;
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public String getUsername() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }
}
