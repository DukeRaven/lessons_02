package com.kirill.model;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Kirill on 05.04.2016.
 */
public class User {

    private String login;
    private String password;
    HashSet<Account> accounts = new HashSet<>();


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return login.equals(user.login);

    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }
}
