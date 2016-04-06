package com.kirill.logic;

import com.kirill.model.User;

import java.util.Scanner;

/**
 * Created by Kirill on 06.04.2016.
 */
public class Application {

    private User user;
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
    private int loginAndRegister() {
        int item;
        int result = 0;
        User localUser;

        while (result == 0) {
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
                    } else {
                        this.user = user;
                        result = 1;
                    }
                    break;
                case 2:
                    System.out.println("== Registration ==");
                    localUser = getUserData();
                    ds.addUser(localUser);
                    System.out.printf("New user '%s' registered\n", localUser.getLogin());
                    result = 1;
                    break;
                case 0:
                    result = -1;
                    break;
            }

        }
        return result;
    }

    public Application() {
        int result = 0;
        System.out.println("Financial calculator");
        while (result == 0) {
            result = loginAndRegister();

        }

    }

}
