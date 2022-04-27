package com.syed.homework.homework0406;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-06
 */
public class ObjectInputStreamDemo {

    private String filePath;

    public ObjectInputStreamDemo(String filePath) {
        this.filePath = filePath;
    }

    public void register(String username, String password) {
        User user = new User(username, password);
        try (ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(filePath));
             ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = objInput.readObject();
            if (null == obj) {
                objOutput.writeObject(new ArrayList<User>().add(user));
            } else {
                List<User> usersList = (List<User>) obj;
                usersList.add(user);
                objOutput.writeObject(usersList);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void login(String username, String password) {
        try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(filePath))) {
            List<User> users = (List<User>) objInput.readObject();
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("登入成功");
                    break;
                }
                System.out.println("登入失败");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "D:\\KindsCode\\MyJavaSE\\src\\com\\syed\\homework\\homework0406\\user.data";
        ObjectInputStreamDemo demo = new ObjectInputStreamDemo(filePath);
        demo.register("admin", "123456");
//        demo.login("admin", "123456");
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class User implements Serializable {
    private static final long serialVersionUID = -2930065340295847414L;
    private String username;
    private String password;
}