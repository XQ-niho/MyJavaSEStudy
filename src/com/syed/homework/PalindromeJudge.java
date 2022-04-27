package com.syed.homework;

import java.util.Scanner;

/**
 * @author qiu
 * @Description: 判断回文
 * @date 2022/3/7 15:19
 */
public class PalindromeJudge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        int num = 0;

        for(int i = 0; i < number.length() / 2; i++){
            if(number.charAt(i) != number.charAt(number.length() - i - 1)){
                System.out.println("不是回文");
            }else{
                num++;
            }
        }

        if(num == number.length() / 2){
            System.out.println("是");
        }

    }
}
