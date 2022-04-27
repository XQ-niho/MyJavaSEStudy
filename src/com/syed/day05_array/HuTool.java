package com.syed.day05_array;

import cn.hutool.core.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author qiu
 * @Description: HuTool工具包
 * @date 2022/3/14 9:44
 *
 * 近年来流行 Hutool
 *
 * 另一个工具包apache下     commons 最流行的java拓展包
 * https://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html
 * commons-lang 基础增强语言包
 * commons-collection 集合相关
 * commons-logging 日志相关
 * ...
 *
 *
 * guava 谷歌工具包
 *
 */
public class HuTool {
    public static void main(String[] args) {
        /*
        数组合并
        public static int[] addAll(int[]...arrays)

        int[]... arrays可变长参数(其本质是数组)

        int...args =={1,2,3};
        int[]...arrays == {{arr1,arr2,arr3}};
         */
        int[] arr1 = {1,2,3};
        int[] arr2 = {3,4,5};
        int[] arr3 = {5,6,7};

        int[] addAll = ArrayUtil.addAll(arr1, arr2, arr3);


        //数组元素添加
        //此方法返回类型为Object
        //强制转换需要注意类型安全问题，否则会报错：Java.lang.ClassCastException
        Integer[] integer = {1,2,3};
        Object append = ArrayUtil.append(integer,10,11,12);
        //Hutool内置的输出方法
        System.out.println(ArrayUtil.toString(append));

        //判断集合中是否包含指定元素
        Boolean contains = ArrayUtil.contains(arr1, 4);
        System.out.println(contains);

        //commons-lang下的数组操作
        int[] addAllOfCommons = ArrayUtils.addAll(arr1,1,2,5);
        System.out.println(ArrayUtils.toString(addAllOfCommons));

    }
}
