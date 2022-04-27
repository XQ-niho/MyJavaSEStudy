package com.syed.homework.homework325;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-27
 */
public class CalcuStringDis {
    public static void main(String[] args) {
        System.out.println(calculateStringDistance("abcdefg","abdec"));
    }

    public static String calculateStringDistance(String expressionA, String expressionB) {

        char[] a = expressionA.toCharArray();
        char[] b = expressionB.toCharArray();
        int[][] len = new int[a.length + 1][b.length + 1];

        for (int i = 0; i < len.length; i++) {
            len[i][0] = i;
        }

        for (int j = 0; j < len[0].length; j++) {
            len[0][j] = j;
        }

        for (int i = 1; i < len.length; i++) {
            for (int j = 1; j < len[0].length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    len[i][j] = len[i - 1][j - 1];
                } else {
                    len[i][j] = Math.min(Math.min(len[i - 1][j], len[i - 1][j - 1]), len[i][j - 1]) + 1;
                }
            }
        }

        return "1 / " + (len[len.length - 1][len[0].length - 1] + 1);
    }
}
