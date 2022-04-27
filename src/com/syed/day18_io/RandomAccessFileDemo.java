package com.syed.day18_io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @program: MyJavaSE
 * @description: 随机访问存取流
 * 可以在文件任意位置进行读或者写的操作,它是一个组合流(基本流+拓展流)
 * @author: USER
 * @create: 2022-04-08
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) {

    }

    /**
     * 业务要求:
     * 读取一个超大型文件(2G以上的文本文件)的最后一行内容
     */
    public static String readLastLine(String path) {
        String lastLine = null;
        /**
         * RandomAccessFile构建时，必须设置打开模式，一般模式为：
         * r 只读模式   rw读写模式   rwd   rws
         */
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r")) {
            //获取文件大小
            long pos = randomAccessFile.length();
            //定义状态变量
            boolean flag = true;
            //循环反向读取字节，如果读取到换行等情况，说明最后一行已读完
            int len;
            while (flag) {
                //把文件指针定位到文件末尾
                randomAccessFile.seek(--pos);
                //读取一个字节
                len = randomAccessFile.read();
                //判断该字节
                switch (len) {
                    case '\n': //换行
                    case '\t': //回车
                    case -1: //文件中就一行内容，-1表示读取完
                        //已经读到换行，重新定位到最后一行起始位置
                        randomAccessFile.seek(pos+1);
                        flag = false;
                }
            }
            lastLine = new String(randomAccessFile.readLine().getBytes("UTF-8"),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastLine;
    }
}
