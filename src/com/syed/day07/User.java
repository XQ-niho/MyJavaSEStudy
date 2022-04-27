package com.syed.day07;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/16 14:55
 */
public class User {

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        //构造方法使用set方法进行属性赋值
        setUsername(username);
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if ("习大大".equals(username)) {
            System.out.println("该名称不能使用");
            this.username = "默认名";
        }else{
            this.username = username; 
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
