package com.syed.day18_io;

import com.syed.util.TextInputUtil;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * @program: MyJavaSE
 * @description:
 * OutputStream调用write()方法是直接把数据写入到目标的文件中的,
 * 而BufferedOutputStream调用write()方法时,它是把数据先存到缓冲中的,并没有直接写入到目标文件中,如果要把缓冲中的数据写到目标文件中,
 * 则可以使用缓冲刷新方式来实现,刷新缓冲的方式:
 * a.流关闭时(无论是手动调用close()还是使用自动关闭方式),都会执行close()方法,而close()方法中会先刷新缓冲(flush()方法)
 * b.手动强制调用flush()方法来刷新缓冲(后面有一些流可以开启自动刷新缓冲能力),实际开发中,一般需要累计到一定的数据量,再调用flush()方法
 *
 * @author: USER
 * @create: 2022-04-06
 */
public class FlushOfOutputStream {
    public static void main(String[] args) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\test.txt", true))) {
            //定义计数器
            int count = 0;
            while (true) {
                String message = TextInputUtil.getString("请您输入内容:");
                if ("q".equalsIgnoreCase(message)) {
                    break;
                }
                //把数据写入到缓冲中
                bos.write(message.getBytes());
                //次数++
                count++;
                //判断
                if (count % 10 == 0) {
                    //手动刷新缓冲
                    bos.flush();
                }
            }
            //bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
