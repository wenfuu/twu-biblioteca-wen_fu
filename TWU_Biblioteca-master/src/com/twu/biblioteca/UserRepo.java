package com.twu.biblioteca;
import	java.util.Arrays;
import	java.util.ArrayList;
import	java.util.List;

public class UserRepo {

    private List<User> userList = new ArrayList<User>();

    public UserRepo(User... users) {
        userList.addAll(Arrays.asList(users));
    }

    public List<User> getUserList() {
        return userList;
    }

}
