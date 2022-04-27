package com.syed.homework;

import org.apache.commons.lang3.ArrayUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author USER
 */
public class Homework0324 {

    public static final Pattern PATTERN = Pattern.compile("[A-Za-z]+");

    public static void main(String[] args) {

    }

    /**
     * 统计一段英文文章中每个单词出现的次数
     * @param letter
     */
    public void countAnyWords(String letter) {
        String[] words = new String[letter.length() / 2];
        int index = 0;
        Matcher matcher = PATTERN.matcher(letter);
        while (matcher.find()) {
            words[index++] = matcher.group();
        }

        //不重复单词
        String[] noRepeatWord = new String[index];
        //统计单词个数
        int[] countAnyWord = new int[index];
        int otherIndex = 0;

        for (int i = 0; i < index; i++) {
            if (!ArrayUtils.contains(noRepeatWord, words[i])) {
                countAnyWord[otherIndex]++;
                noRepeatWord[otherIndex++] = words[i];
                continue;
            }
            for (int j = 0; j < otherIndex; j++) {
                if (words[i].equals(noRepeatWord[j])) {
                    countAnyWord[j]++;
                }
            }
        }
        for (int i = 0; i < otherIndex; i++) {
            System.out.println(noRepeatWord[i] + "---->" + countAnyWord[i]);
        }
    }

    /**
     * 反转一句英文语句中所有单词的顺序
     *
     * @param target
     * @return
     */
    public StringBuilder reverseLetter(String target) {
        StringBuilder wordsOfReverse = new StringBuilder();
        String[] words = target.split("[.,;! ?]");
        for (int i = words.length - 1; i >= 0; i--) {
            words[i] += " ";
            wordsOfReverse.append(words[i]);
        }
        return wordsOfReverse;
    }

    /**
     * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，
     * 然后输出输入字符串中含有该字符的个数。不区分大小写。
     * @param src
     * @param target
     * @return
     */
    public int charAppear(String src, char target) {
        if (target >= 'A' && target <= 'Z') {
            src = src.toUpperCase();
        } else {
            src = src.toLowerCase();
        }
        Character tar = target;
        String patten = "[A-Z0-9a-z]+";
        int count = 0;
        if (src.matches(patten)) {
            for (int i = 0; i < src.length(); i++) {
                Character srcChar = src.charAt(i);
                if (tar.compareTo(srcChar) == 0) {
                    count++;
                }
            }
        } else {
            System.out.println("只允许输入字母和数字");
        }
        return count;
    }

    /**
     * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
     * @param hexNumber
     * @return
     */
    public Integer toDecimal(String hexNumber) {
        Integer decimal = null;
        String patten = "0[xX][0-9a-fA-F]+";
        if (hexNumber.matches(patten)) {
            decimal = Integer.parseInt(hexNumber.substring(2), 16);
        } else {
            System.out.println("输入的16进制不合法");
        }
        return decimal;
    }
}
