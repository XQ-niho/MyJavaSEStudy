package com.syed.homework.homework0328;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-28
 */
public class GetAge {
    public static void main(String[] args) {
        GetAge getAge = new GetAge();
        int age = getAge.getAge();
        System.out.println(age);

    }

    public int getAge() {
        int pow3, pow4;
        int age = 0;
        for (int i = 10; i < 32; i++) {
            pow3 = i * i * i;
            pow4 = i * i * i * i;
            if (!isRepeat("" + pow3 + pow4)) {
                age = i;
                break;
            }
        }
        return age;
    }

    public static boolean isRepeat(String age) {
        Set<Character> ch = new HashSet<>();
        char[] chars = age.toCharArray();
        for (char c : chars) {
            ch.add(c);
        }
        if (ch.size() != chars.length) {
            return true;
        }
        return false;
    }
}
