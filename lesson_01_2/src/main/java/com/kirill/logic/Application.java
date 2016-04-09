package com.kirill.logic;

import com.kirill.model.Account;
import com.kirill.model.Record;
import com.kirill.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Kirill on 06.04.2016.
 */
public class Application {

    private Logger l = LoggerFactory.getLogger(Application.class);

    private Scanner sc = new Scanner(System.in);
    private DataSourceImpl ds = new DataSourceImpl();


    private User getUserData() {
        String login;
        String password;

        System.out.print("Enter login: ");
        login = sc.next();
        System.out.print("Enter password: ");
        password = sc.next();
        return new User(login, password);

    }

    private User menuLogin() {
        int item;
        User localUser = null;

        while (localUser == null) {
            System.out.println("== Menu ==");
            System.out.println("1 - Login");
            System.out.println("2 - Register new user");
            System.out.println("0 - Exit");
            System.out.print("Please choose menu item: ");
            item = sc.nextInt();

            switch (item) {
                case 1:
                    System.out.println("== Login ==");
                    localUser = getUserData();
                    User user = ds.getUser(localUser.getLogin());
                    if (user == null || !user.getPassword().equals(localUser.getPassword())) {
                        System.out.println("User does not exists or password is invalid");
                        localUser = null;
                    }
                    break;
                case 2:
                    System.out.println("== Registration ==");
                    localUser = getUserData();
                    ds.addUser(localUser);
                    System.out.printf("New user '%s' registered\n", localUser.getLogin());
                    break;
                case 0:
                    localUser = null;
                    break;
            }

        }
        return localUser;
    }

    private Account menuAccounts(User user) {
        Account acc = null;
        while (acc == null) {
            System.out.println("== Accounts ==");
            HashSet<Account> accounts = (HashSet) ds.getAccounts(user);
            for (Account a : accounts) {
                System.out.println(a.toString());
            }
            System.out.println("Enter 1 to add new account");
            System.out.println("Enter 2 to view transaction history");
            System.out.println("Enter 0 to exit");
            int point = sc.nextInt();
            switch (point) {
                case 1:
                    Account tmpAcc = new Account();
                    System.out.println("Enter description:");
                    tmpAcc.setDescription(sc.next());
                    System.out.println("Enter reminder:");
                    tmpAcc.setRemainder(sc.nextFloat());
                    ds.addAccount(user, tmpAcc);
                    break;
                case 2:
                    System.out.println("Enter account id:");
                    long accId = sc.nextLong();
                    for (Account a : accounts) {
                        if (a.getId() == accId) {
                            acc = a;
                            break;
                        }
                    }
                    break;
                case 0:
                    acc = null;
                    break;
            }
        }
        return acc;
    }

    private int menuRecords(Account acc) {
        int result = 0;
        while (result == 0) {
            System.out.println("== Records ==");
            HashSet<Record> records = (HashSet) ds.getRecords(acc);
            for (Record r : records) {
                System.out.println(r.toString());
            }
            System.out.println("Enter 1 to add new record");
            System.out.println("Enter 0 to exit");
            int point = sc.nextInt();
            switch (point) {
                case 1:
                    Record tmpRec = new Record();
                    System.out.println("Enter description:");
                    tmpRec.setDescription(sc.next());
                    System.out.println("Enter amount: ");
                    tmpRec.setAmount(sc.nextFloat());
                    System.out.println("Enter direction (1 - income, 0 - consumption):");
                    tmpRec.setIncoming(sc.nextInt() == 1 ? true : false);
                    System.out.println("Enter transaction date(format dd.mm.yyyy):");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
                    try {
                        tmpRec.setDate(sdf.parse(sc.next()));
                        ds.addRecord(acc, tmpRec);
                    } catch (ParseException e) {
                        l.error("Error with date format");
                    }
                    break;
                case 0:
                    result = -1;
                    break;
            }
        }
        return result;
    }

    public Application() {
        l.info("Application stared");
        User user;
        Account acc;
        int i;

        System.out.println("Financial calculator");
        while (true) {
            user = menuLogin();
            if (user != null) {
                acc = menuAccounts(user);
                if (acc != null) {
                    i = menuRecords(acc);
                    if (i == -1)
                        break;
                } else
                    break;

            } else
                break;

        }
        l.info("Application stopped");

    }

}
