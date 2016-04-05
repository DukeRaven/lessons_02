package com.kirill.dao;

import com.kirill.model.Account;
import com.kirill.model.IDataSource;
import com.kirill.model.Record;
import com.kirill.model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Kirill on 05.04.2016.
 */
public class DataSourceImpl implements IDataSource {

    HashMap<String, User> users = new HashMap<>();
    HashMap<Long, Record> records = new HashMap<>();
    AtomicLong seq = new AtomicLong();

    @Override
    public User getUser(String name) {
        return users.get(name);
    }

    @Override
    public Set<String> getUserNames() {
        return users.keySet();
    }

    @Override
    public Set<Account> getAccounts(User owner) {
        return accounts.keySet();
    }

    @Override
    public Set<Record> getRecords(Account account) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void addAccount(User user, Account account) {

    }

    @Override
    public void addRecord(Account account, Record record) {

    }

    @Override
    public User removeUser(String name) {
        return null;
    }

    @Override
    public Account removeAccount(User owner, Account account) {
        return null;
    }

    @Override
    public Record removeRecord(Account from, Record record) {
        return null;
    }
}
