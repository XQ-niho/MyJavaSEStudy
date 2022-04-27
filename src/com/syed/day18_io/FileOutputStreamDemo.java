package com.syed.day18_io;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @program: MyJavaSE
 * @description: Java字节输出流
 * @author: USER
 * @create: 2022-04-06
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        //把程序中的数据写入到本地文件中
        String data = "管理员:123456\n";
        /**
         * 1.根据源头或者目标创建对应的IO对象
         *  注意:
         *  路径正确的情况下,FileOutputStream输出流会自动创建文件
         *
         *  每次运行,流都会重新创建,对应的文件也会重置,无法实现数据累加,如何解决?
         *  开启IO流的自动追加模式
         *
         *  补充:如果打开的文件没有换行,原因是使用了windows的记事本软件(windows10之前)
         *  推荐几个记事本软件:
         *      Notepad++,Editplus
         */
        //try (OutputStream outputStream = new FileOutputStream("D:\\user.txt")) {

        //追加模式,第二个参数为true表示开启追加模式
        try (OutputStream outputStream = new FileOutputStream("D:\\user.txt",true)){
            /**
             * 2.写入目标文件
             *
             * 关于乱码问题:
             * 乱码是中文才有的情况,英文不存在乱码问题,英文是一个字母一个字节,中文是两个/三个字节一个汉字
             * 常规中文字符集:
             *      UTF-8(推荐)       一个中文三个字节
             *      GBK              一个中文两个字节
             */
            //outputStream.write(data.getBytes(StandardCharsets.UTF_8));
            outputStream.write(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
