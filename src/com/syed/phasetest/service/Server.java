package com.syed.phasetest.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.syed.phasetest.constans.IConstants.SERVER_PORT;

/**
 * @program: MyJavaSEStudy
 * @description:
 * @author: USER
 * @create: 2022-04-26
 */
public class Server {

    /**
     * 服务器处理对象
     */
    private ServerHandler serverHandler;

    public static void main(String[] args) {
        new Server().start();
    }

    /**
     * 服务器启动
     */
    private void start() {
        //创建服务端套接字对象
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)){
            System.out.println("服务器正常启动...");
            //服务器启动成功后，加载股票数据
            serverHandler = new ServerHandler();
            //循环等待客户端连接
            while(true) {
                Socket client = serverSocket.accept();
                //由于默认处理客户端请求的线程是main()线程,所以一个客户端连接成功过后就会发生阻塞
                //我们应该为每个客户端都单独开启一个线程来进行处理(多线程)
                serverHandler.handlerSocket(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
