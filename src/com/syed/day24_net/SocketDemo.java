package com.syed.day24_net;

import com.syed.util.TextInputUtil;

import java.io.*;
import java.net.Socket;

/**
 * @program: MyJavaSE
 * @description: 客户端套接字
 *  注意: 如果服务端没有打开,则启动客户端会抛出异常:
 *      java.net.ConnectException: Connection refused: connect
 * @author: USER
 * @create: 2022-04-12
 */
public class SocketDemo {
    public static void main(String[] args) {
        //注意: 套接字对象使用完毕后也要进行资源释放(等同于IO流)
        try (Socket socket = new Socket("127.0.0.1",12580)){
            /**
             *  创建客户端套接字对象
             *  参数:服务器IP地址,通信端口号
             *  IP地址表示服务器网络上的"地址",127.0.0.1或者localhost表示本机
             *  端口号0~65535,1024以下为系统占用,不要使用,1024~65535都可以使用,
             *  但是要避免和一些软件的端口冲突,例如:mysql默认端口1521,tomcat默认端口8080...,否则会出现端口冲突
             */
            //向服务端发送信息，利用桥接器把字节流转换成字符流
            PrintWriter fou = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            BufferedReader fin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                //把用户输入的内容发送到服务器
                fou.println(TextInputUtil.getString("请输入内容："));
                System.out.println(fin.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
