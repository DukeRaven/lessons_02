package com.kirill.logic;

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
    HashMap<User, HashSet<Account>> accounts = new HashMap<>();
    HashMap<Account, HashSet<Record>> records = new HashMap<>();
    AtomicLong seq = new AtomicLong();

    public long getNextId() {
        return seq.getAndIncrement();
    }

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
        return accounts.get(owner);
    }

    @Override
    public Set<Record> getRecords(Account account) {
        return records.get(account);
    }

    @Override
    public void addUser(User user) {
        users.put(user.getLogin(), user);
    }

    @Override
    public void addAccount(User user, Account account) {
        HashSet<Account> userAccounts = (HashSet<Account>) getAccounts(user);
        account.setId(getNextId());
        userAccounts.add(account);
        accounts.put(user, userAccounts);
    }

    @Override
    public void addRecord(Account account, Record record) {
        HashSet<Record> accountRecords = (HashSet<Record>) getRecords(account);
        record.setId(getNextId());
        accountRecords.add(record);
        records.put(account, accountRecords);
    }

    @Override
    public User removeUser(String name) {
        User user = users.get(name);
        HashSet<Account> userAccounts = (HashSet<Account>) getAccounts(user);
        for (Account a : userAccounts) {
            records.remove(a);
        }
        accounts.remove(user);
        users.remove(name);
        return user;
    }

    @Override
    public Account removeAccount(User owner, Account account) {
        records.remove(account);
        HashSet<Account> ownerAccounts = (HashSet<Account>) getAccounts(owner);
        ownerAccounts.remove(account);
        accounts.remove(owner);
        accounts.put(owner, ownerAccounts);
        return account;
    }

    @Override
    public Record removeRecord(Account from, Record record) {
        HashSet<Record> accountReords = (HashSet<Record>) getRecords(from);
        accountReords.remove(record);
        records.remove(from);
        records.put(from, accountReords);
        return record;
    }
}
