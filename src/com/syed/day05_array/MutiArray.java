package com.syed.day05_array;

import java.util.Arrays;

/**
 * @author qiu
 * @Description: 多维数组
 * @date 2022/3/11 16:51
 */
public class MutiArray {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];

        int[][] intArr = new int[][]{{1, 2, 3, 4,}, {2, 5, 4, 9}, {3, 4, 5, 6}};

        //JDK内置二维数组遍历方法
        System.out.println(Arrays.deepToString(intArr));

        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                System.out.print(intArr[i][j] + "\t");
            }
            System.out.println();
        }
    }


}
