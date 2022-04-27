package com.syed.day12_regex;

/**
 * @description: Java正则表达式
 * @author: qiu
 * @date: 2022/3/24 16:34
 */
public class RegexDemo {
    public static void main(String[] args) {
        /**
         * +    *    ?
         * []   [^ ]
         * {n}  {n,}  {n,m}
         * \d   \w
         * |
         */

        //email正则表达式
        String pattern = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        //匹配正则表达式,如果匹配返回true,反之返回false
        boolean matches = "syedu-sy@qq.com".matches(pattern);
        System.out.println(matches);
    }
}
