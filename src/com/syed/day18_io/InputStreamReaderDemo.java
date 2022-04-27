package com.syed.day18_io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @program: MyJavaSE
 * @description: 桥接器 --- 把字节流转换为字符流
 * java.io.InputStreamReader
 * java.io.OutputStreamWriter
 * @author: USER
 * @create: 2022-04-08
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        try (InputStreamReader fin = new InputStreamReader(new FileInputStream(""), Charset.defaultCharset())) {
            int len;
            while ((len = fin.read()) != -1) {
                System.out.println((char) len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 实现获取用户键盘输入(不允许使用Scanner)
         */
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("请输入内容：");
            String line = bufferedReader.readLine();
            System.out.println("你输入的内容为：" + line);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
