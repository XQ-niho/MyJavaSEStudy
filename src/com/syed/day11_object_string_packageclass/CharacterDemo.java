package com.syed.day11_object_string_packageclass;

/**
 * @description: char类型包装类
 * @author: qiu
 * @date: 2022/3/24 15:09
 */
public class CharacterDemo {
    public static void main(String[] args) {
        Character c1 = 'A';
        Character c2 = 'a';
        Character c3 = '我';
        Character c4 = ' ';
        Character c5 = '\u0000';

        //1、判断是否为字母，不只为英文字母
        boolean letter = Character.isLetter(c1);

        //2、判断是否为数字
        boolean digit = Character.isDigit(c2);

        //3、判断是否是空白
        boolean whiteSpace = Character.isWhitespace(c4);

        //4、判断是否为大小写
        boolean upperCase = Character.isUpperCase(c1);
        boolean lowerCase = Character.isLowerCase(c2);
    }
}
