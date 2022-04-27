package com.syed.day01_data;

/**
 * @author qiu
 * @date 2022/3/4 9:27
 */
public class DataTypeDemo {
    public static void main(String[] args) {

        byte b = 127;
        //-32768-32767 占2个字节
        short c = 32767;
        //int 占4个字节 -2147483648-2147483647
        //java中一个整数默认就是int
        int s = 2147483647;
        //long占8个字节
        long l = 9223372036854775807L;


        //java中小数默认为double
        //占4个字节
        float f = 3.14F;
        //占8个字节
        double d = 3.14;


        //占1个字节
        boolean bool = true;


        //占2个字节
        char ch = 'A';
    }
}
