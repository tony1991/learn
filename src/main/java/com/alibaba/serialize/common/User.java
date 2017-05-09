package com.alibaba.serialize.common;

import java.io.Serializable;

/*
 * 不加implements Serializable，会报错
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String username;
    private int age;
    
    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
}
