package com.syed.day18_io;

import java.io.*;

/**
 * @program: MyJavaSE
 * @description: 利用字符流混淆CSS代码
 * @author: USER
 * @create: 2022-04-07
 */
public class MixCode {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("typebase.css"));
             PrintWriter writer = new PrintWriter(new FileWriter("typebase_min.css"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("/*")) {
                    do{
                        line = reader.readLine();
                    }while (line.endsWith("*/"));
                }
                writer.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
