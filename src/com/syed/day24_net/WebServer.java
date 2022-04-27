package com.syed.day24_net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: MyJavaSE
 * @description: 利用Java网络编程实现服务器, 可以通过浏览器来访问我服务器中的HTML页面
 *
 * 1.启动服务器后,通过浏览器访问地址:
 * http://localhost:12580/JavaSE/web/index.html
 *
 * 控制台输出的请求头信息:
 * GET /JavaSE/web/index.html HTTP/1.1
 * Host: localhost:12580
 * User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:99.0) Gecko/20100101 Firefox/99.0
 * Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,im...
 * @author: USER
 * @create: 2022-04-13
 */
public class WebServer {
    public static void main(String[] args) {
        //创建服务端套接字
        //接受客户端的连接
        try (ServerSocket serverSocket = new ServerSocket(12580)) {
            while (true) {
                Socket client = serverSocket.accept();
                new Thread(new Web(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Web implements Runnable{

        private Socket socket;

        public Web(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try{
                //处理请求信息
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String htmlPath = reader.readLine().split(" ")[1];
                htmlPath = htmlPath.substring(htmlPath.indexOf("/", htmlPath.indexOf("/") + 1) + 1);
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(htmlPath));
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                //向浏览器(客户端)回写数据
                //a.先发响应头信息数据，固定写法(!!!)
                bos.write("HTTP/1.1 200 OK\r\n".getBytes());
                bos.write("Content_TYpe:text/html\r\n".getBytes());
                bos.write("\r\n".getBytes());
                //b.然后再发送页面数据
                byte[] buf = new byte[1024];
                while (bis.read(buf) != -1){
                    bos.write(buf);
                }
                bos.close();
                bis.close();
                reader.close();
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
