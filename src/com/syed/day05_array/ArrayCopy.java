package com.syed.day05_array;

import java.util.Arrays;

/**
 * @author qiu
 * @Description: 数组内置方法
 * @date 2022/3/10 16:53
 */
public class ArrayCopy {
    public static void main(String[] args) {
        //数组增删
        int[] arr = new int[]{1,2,3};

        //增加元素
        //创建一个新数组
        int[] newArr = new int[arr.length+1];

        //把旧数组复制到新数组
        // JDK6开始 System.arraycopy(Object src, int srcPos, Object dest, int destPos,int length);
        // src      原数组
        // srcPos   拷贝元素所在原数组的起始下标
        // dest     目标数组
        // desPos   元素复制到目标数组的起始下标
        // length   拷贝一次一共复制多少个元素

        System.arraycopy(arr, 0, newArr, 0, 2);
        newArr[2] = 8;
        System.arraycopy(arr, 2, newArr, 3,1);
        System.out.println(Arrays.toString(newArr));

        //JDK6开始出现的拷贝方法
        //Arrays.copyOf();尾部扩容或减容
        int[] arr3 = {1,2,3};
        int[] newArr3 = Arrays.copyOf(arr3, 10);
        System.out.println(Arrays.toString(newArr3));


    }
}
