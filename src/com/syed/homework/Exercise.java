package com.syed.homework;

/**
 * @author qiu
 * @Description: 双色球摇奖
 * @date 2022/3/11 9:39
 */
public class Exercise {
    public static void main(String[] args) {
        int[] bolls = new int[32];
        for(int i = 0; i < bolls.length; i++){
            bolls[i] = i + 1;
        }

        for(int i = 0; i < 5; ){
            int index = (int) (Math.random()*32);
            if(bolls[index] == -1){
                continue;
            }
            System.out.println(bolls[index] + '\t');
            bolls[index] = -1;
            i++;
        }


    }
}
