package com.syed.day24_net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: MyJavaSE
 * @description: 服务端套接字
 * @author: USER
 * @create: 2022-04-12
 */
public class ServerSocketDemo {
    public static void main(String[] args) {
        /**
         * 创建服务端套接字对象
         * 参数:通信端口
         * 注意:如果开启多个服务器,会出现端口占用,则抛出异常:
         * java.net.BindException: Address already in use: bind
         */
        try {
            ServerSocket serverSocket = new ServerSocket(12580);
            //获取当前使用的端口
            System.out.println("服务器已启动，正在监听：[" + serverSocket.getLocalPort() + "接口]");
            while (true) {
                /**
                 * 等待客户端的连接
                 * 注意:如果没有客户端来连接,则accept()方法会一直等待阻塞,当有客户端连接成功,则该方法返回一个连接成功的
                 * 客户端套接字对象
                 */
                Socket accept = serverSocket.accept();
                //多线程
                new Thread(() -> {
                    try {
                        //获取连接成功的客户端的信息,例如IP地址
                        String hostAddress = accept.getInetAddress().getHostAddress();
                        System.out.println("[" + hostAddress + "]上线了");
                        //接收客户端发送的信息
                        BufferedReader fin = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                        PrintWriter fou = new PrintWriter(new OutputStreamWriter(accept.getOutputStream()), true);
                        while(true){
                            String message = fin.readLine();
                            System.out.println(message);
                            fou.println(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
