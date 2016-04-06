package com.kirill.model;

import java.util.ArrayList;

/**
 * Created by Kirill on 05.04.2016.
 */
public class Account {

    private long id;
    private String description;
    private float remainder;



    public Account(long id, String description) {
        this.id = id;
        this.description = description;
        this.remainder = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        return id == account.id;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRemainder() {
        return remainder;
    }

    public void setRemainder(float remainder) {
        this.remainder = remainder;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
