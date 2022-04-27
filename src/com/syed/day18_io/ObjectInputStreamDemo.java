package com.syed.day18_io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

/**
 * @program: MyJavaSE
 * @description: 如果是多个用户该怎么写？？？homework0406
 * @author: USER
 * @create: 2022-04-06
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) {
        ObjectInputStreamDemo demo = new ObjectInputStreamDemo();
        demo.registerUser("admin", "123456");
        demo.loginUser("admin", "123456");
    }

    /**
     * 注册用户
     * 把对象写入到目标文件中
     */
    public void registerUser(String username, String password) {
        User user = new User(username, password);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:\\user.data"))) {
            outputStream.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录
     * 从文件中读取用户信息
     */
    public void loginUser(String username, String password) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:\\user.data"))) {
            User user = (User) inputStream.readObject();
            System.out.println(user);
           /* if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                System.out.println("登录成功!");
            } else {
                System.out.println("登录失败!");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 把对象写入到文件中的操作叫做持久化,也叫作序列化,
 * Java中要求被序列化的对象必须实现java.io.Serializable标记接口,才能序列化,否则会抛出异常:
 * java.io.NotSerializableException,不能序列化异常
 *
 * 注意: 实现java.io.Serializable接口后最好还要添加序列化ID,通过idea的配置后,可以在需要产生
 * 序列化id的类名上输入alt+回车来产生serialVersionUID
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class User implements Serializable{
    //JDK14新出的注解,用来标示序列化ID,大家直接删除忽略即可
    //@Serial
    private static final long serialVersionUID = -574625523808970606L;
    private String username;

    //transient关键字的作用就是可以在持久化操作中,忽略该属性!
    private transient String password;
}
