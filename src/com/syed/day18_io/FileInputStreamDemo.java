package com.syed.day18_io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: MyJavaSE
 * @description: Java字节输入流
 * @author: USER
 * @create: 2022-04-06
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        //读取本地文件到内存中，并且打印在控制台上
        //1、根据源头和目标选择相应的IO对象并且创建
        InputStream inputStream = null;
        try {
            //获取文件的总大小
            //long length = new File("D:\\BAM练习.txt").length();

            //获取当前流中剩余的数据量
            //注意: 此方法开始时的值等于文件大小,但是只要发生读取,则数值会越来越少
            //int available = inputStream.available();

            inputStream = new FileInputStream("D:\\KindsCode\\MyJavaSE");
            int len;
            //2.循环读取,读取单个字节,如果读取到-1,则表示读取完毕
            while ((len = inputStream.read()) != -1) {
                System.out.println((char) len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流,释放资源
            //注意: 一般会在finally中进行资源释放操作,当然还可以使用自动关闭流的方式来简化此操作
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * 自动关闭流的方式
         *  注意:此处使用了自动关闭流的操作来简化finally代码,但是必须满足如下要求:
         *      1.JDK7.0及其以上
         *      2.流支持自动关闭操作,即该流实现了AutoCloseable接口(不是所有的IO流都能自动关闭的!)
         *
         */
        try (InputStream fin = new FileInputStream("D:\\BAM练习.txt")) {
            int len;
            while ((len = fin.read()) != -1) {
                System.out.println((char) len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
