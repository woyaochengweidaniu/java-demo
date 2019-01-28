package com.example.javademo.lambda;

import lombok.Data;

@Data
public class User {

    private String username;
    private String password;
    private int age;
    private String sex;
    private String phone;

    public User(){};
    public User(String username, int age, String sex){
        this.username = username;
        this.age = age;
        this.sex = sex;
    };
}
