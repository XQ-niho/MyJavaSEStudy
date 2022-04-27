package com.syed.homework.homework0406;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-07
 */
public class ObjectInputStreamDemo2 {
    public static void main(String[] args) {
        registerUser("admin3", "123456");
        loginUser("admin3", "123456");
    }

    /**
     * 注册用户
     * 把对象写入到目标文件中
     *
     * 注意:
     * a.如果先发生读取,由于还不存在文件,所以会抛出文件未找到异常: java.io.FileNotFoundException
     * b.如果手动添加文件,文件中没有任何内容,则直接读取会抛出意外读取到文件末尾的异常: java.io.EOFException
     */
    public static void registerUser(String username, String password) {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            List<User> users = null;
            outputStream = new ObjectOutputStream(new FileOutputStream("D:\\KindsCode\\MyJavaSE\\src\\com\\syed\\homework\\homework0406\\user.data"));
            try {
                inputStream = new ObjectInputStream(new FileInputStream("D:\\KindsCode\\MyJavaSE\\src\\com\\syed\\homework\\homework0406\\user.data"));
                //读取文件中的集合
                users = (List<User>) inputStream.readObject();
            } catch (EOFException e) {
                users = new ArrayList<>();
                outputStream.writeObject(users);
            }
            //新用户
            User user = new User(username, password);
            users.add(user);
            //把添加号用户的集合写回到文件中
            outputStream.writeObject(users);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 登录
     * 从文件中读取用户信息
     */
    public static void loginUser(String username, String password) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:\\KindsCode\\MyJavaSE\\src\\com\\syed\\homework\\homework0406\\user.data"))) {
            List<User> users = (List<User>) inputStream.readObject();
            System.out.println(users);
            boolean success = false;
            for (User u : users) {
                System.out.println(u);
                /*if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                    success = true;
                    break;
                }*/
            }
            /*if (success) {
                System.out.println("登录成功!");
            } else {
                System.out.println("登录失败!");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
