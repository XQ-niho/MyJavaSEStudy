package com.syed.day24_net;

import java.io.*;
import java.net.Socket;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-12
 */
public class FileUploadClient {
    public static void main(String[] args) {
        //创建流对象,先读,后写
        //a.从客户端本地文件中读取数据到程序中输入流
        //b.把数据发送到服务端的输出流
        //c.接受服务端发送的完成信息流
        try{
            Socket socketClient = new Socket("127.0.0.1",12580);
            BufferedInputStream fin = new BufferedInputStream(new FileInputStream("C:\\Users\\USER\\Desktop\\cels.zip"));
            BufferedOutputStream fou = new BufferedOutputStream(socketClient.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            //读写数据
            byte[] buf = new byte[1024];
            while (fin.read(buf) != -1){
                fou.write(buf);
                fou.flush();
            }
            /**
             * shutdownXXX方法是关闭连接,不关闭套接字对象
             * 当调用Socket.shutdownInput()后，还能够往该套接字中写数据（执行OutputStream.write( )）
             * 当调用Socket.shutdownOutput()后，还能够往该套接字中读数据（执行InputStream.read( )）
             * shutdown() 用来关闭连接，而不是套接字，不管调用多少次 shutdown()，套接字依然存在，直到调用 close() / closesocket() 将套接字从内存清除。
             * close() / closesocket() 用来关闭套接字，将套接字描述符（或句柄）从内存清除，之后再也不能使用该套接字
             */
            // 关闭输出流,通知服务端,写出数据完毕
            socketClient.shutdownOutput();
            String message = reader.readLine();
            System.out.println(message);
            reader.close();
            socketClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
