package com.syed.homework.homework0329;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-29
 */

public class Exercise1 {

    public static final Pattern PATTERN = Pattern.compile("[a-zA-Z]+");

    public static void main(String[] args) {
        Exercise1 c = new Exercise1();
        String content = "There are moments in life when you miss someone so much that you just want to pick them from your dreams and hug them for real! Dream what you want to dream;go where you want to go";
        c.wordsSort(c.getWordsAndCount(c.getWords(content)));
    }

    /**
     * 排序
     * @param map
     */
    public void wordsSort(Map<String, Integer> map) {
        if (map != null && map.size() > 0) {
            List<Map.Entry<String, Integer>> sortList = new ArrayList<>(map.entrySet());
            sortList.sort((o1, o2) -> {
                int result = o2.getValue().compareTo(o1.getValue());
                if (result == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return result;
            });
            sortList.forEach(System.out::println);
        }
    }

    /**
     * 获取单词次数
     *
     * @param src
     * @return
     */
    public Map<String, Integer> getWordsAndCount(String[] src) {
        Map<String, Integer> wordsCount = null;
        if (src != null && src.length > 0) {
            wordsCount = new HashMap<>(20);
            for (String s : src) {
                if (wordsCount.containsKey(s)) {
                    wordsCount.put(s, wordsCount.get(s) + 1);
                } else {
                    wordsCount.put(s, 1);
                }
            }
        }
        return wordsCount;
    }

    /**
     * 得到单词
     *
     * @param src
     * @return
     */
    public String[] getWords(String src) {
        if (src == null || src.length() == 0) {
            return null;
        }
        src = src.toLowerCase();
        String[] words = {};
        Matcher matcher = PATTERN.matcher(src);
        while (matcher.find()) {
            String word = matcher.group();
            words = ArrayUtils.add(words, word);
        }
        return words;
    }
}
