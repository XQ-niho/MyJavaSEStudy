package com.syed.homework.homowork0331;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description: 读取一个本地文件, 文件中可以输入任意文章, 然后在控制台上模拟程序员打字的效果,
 * 即一个字一个字或者一个词一个词打印, 时而快时而慢, 越贴近真实输入效果越好
 * @author: USER
 * @create: 2022-03-31
 */

public class SimulationPrint {
    public static void main(String[] args) {
        try {
            List<String> words = Files.readAllLines(Paths.get("src/com/syed/homework/homework0329/v.dic"));
            for (String word : words) {
                char[] chars = word.toCharArray();
                for (char c : chars) {
                    System.out.print(c);
                    try {
                        Thread.sleep((long) (Math.random() * 200));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

