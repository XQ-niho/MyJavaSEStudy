package com.syed.day18_io;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @program: MyJavaSE
 * @description: Java字符输出流
 * @author: USER
 * @create: 2022-04-07
 */
public class FileWriterDemo {
    public static void main(String[] args) {
        /*try (Writer writer = new FileWriter("D:\\test.txt", true)) {
         *//*for (; ; ) {
                String line = InputUtil.getStrLine("请您输入内容:");
                if ("q".equalsIgnoreCase(line)) {
                    break;
                }
                writer.write(line);
            }*//*
            writer.write("def你好!");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /**
         * BufferedWriter的write()方法默认是把数据先放入到缓冲中,然后当调用flush()方法或者close()方法后,会一次性
         * 把数据刷入到文件中,但是这样可能让缓冲数据较多,同样也会影响性能,所以,一般在开发中,我们是采用"批量"思维来处理
         *
         * 当然如果想要每次write()都立即生效的话,可以手动调用flush()方法,或者开启字符流推荐使用的类PrintWriter的自动刷新缓冲模式
         * PrintWriter,这是开发中推荐使用的字符输出流,它相当于是多重功能集于一身的强大组合流(字符输出流,带缓冲,自动刷新,以及其他特性...)
         */
        //try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\test.txt", true))) {

        try (PrintWriter writer = new PrintWriter(new FileWriter("D:\\test.txt", true), true)) {
            //try (PrintWriter writer = new PrintWriter("D:\\test.txt")) {
            for (int i = 0; i < 10000; i++) {
                //print方法是PrintWriter特有的写方法
                writer.println("abc你好!");
                /*if (i % 10 == 0) {
                    //手动刷新缓冲
                    writer.flush();
                }*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
