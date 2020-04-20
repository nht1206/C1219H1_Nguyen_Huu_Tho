package com.codegym.dao;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> users;
    static {
        users = new ArrayList<>();

        User user1 = new User();
        user1.setAccount("dieu my");
        user1.setPassword("123123");
        user1.setName("Dieu My");
        user1.setEmail("my@gmail.com");
        user1.setAge(23);
        users.add(user1);

        User user2 = new User();
        user2.setAccount("my tinh");
        user2.setPassword("123123");
        user2.setName("My Tinh");
        user2.setEmail("tinh@gmail.com");
        user2.setAge(25);
        users.add(user2);

        User user3 = new User();
        user3.setAccount("huu tho");
        user3.setPassword("123123");
        user3.setName("Huu Tho");
        user3.setEmail("tho@gmail.com");
        user3.setAge(21);
        users.add(user3);
    }
    public static User checkLogin(Login login){
        for (User user : users){
            if (user.getAccount().equals(login.getAccount()) && user.getPassword().equals(login.getPassword())){
                return user;
            }
        }
        return null;
    }
}
