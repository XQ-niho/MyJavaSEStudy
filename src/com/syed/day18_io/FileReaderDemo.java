package com.syed.day18_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description: Java字符输入流
 * @author: USER
 * @create: 2022-04-07
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        /**
         * BIO
         */
        //此方法是每次读一个字符，效率低
        try(Reader reader = new FileReader("")){
            int len;
            while((len = reader.read()) != -1){
                System.out.println((char) len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        //使用带缓冲的字符流
        try(BufferedReader reader = new BufferedReader(new FileReader(""))){
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        /**
         * NIO JDK7.0开始使用
         */
        try {
            List<String> stringList = Files.readAllLines(Paths.get(""));
            stringList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 第三方框架
         */
        //1.guava
        /*try {
            List<String> stringList = Files.readLines(new File("D:\\BAM练习.txt"), Charset.defaultCharset());
            stringList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //2.hutool
        /*List<String> stringList = FileUtil.readLines("D:\\BAM练习.txt", "UTF-8");
        stringList.forEach(System.out::println);*/

        //3.commons-io
        /*try {
            List<String> stringList = FileUtils.readLines(new File("D:\\BAM练习.txt"), "UTF-8");
            stringList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
