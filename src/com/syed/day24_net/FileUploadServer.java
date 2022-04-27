package com.syed.day24_net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-12
 */
public class FileUploadServer {

    public static void main(String[] args) {
        //1.创建服务端套接字对象
        try (ServerSocket fileUploadServer = new ServerSocket(12580)) {
            while (true) {
                //2.建立连接
                Socket fileUploadClient = fileUploadServer.accept();
                //多线程
                new Thread(() -> {
                    //3.创建流对象,先读,后写
                    //a.读取客户端发送过来数据的输入流
                    //b.写入服务器磁盘使用的输出流
                    PrintWriter printWriter = null;
                    try (BufferedInputStream fileRead = new BufferedInputStream(fileUploadClient.getInputStream());
                         BufferedOutputStream fileWrite = new BufferedOutputStream(
                                 new FileOutputStream("D:\\upload" + UUID.randomUUID() + ".zip"))) {
                        printWriter = new PrintWriter(new OutputStreamWriter(fileUploadClient.getOutputStream()));
                        //4.读写数据
                        byte[] buf = new byte[1024];
                        while (fileRead.read(buf) != -1) {
                            fileWrite.write(buf);
                            fileWrite.flush();
                        }
                        printWriter.println("上传成功");
                    } catch (IOException e) {
                        printWriter.println("上传失败!");
                    }finally {
                        printWriter.close();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
