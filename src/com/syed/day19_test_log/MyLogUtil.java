package com.syed.day19_test_log;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * description：自定义日志工具 -- 把程序运行的错误信息写入到本地日志文件中
 * @author Administrator
 * @date 2022/4/8 10:55
 */
public class MyLogUtil {
    public static void log(Exception exception) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter("D:\\log\\" + LocalDate.now() + ".log", true), true)) {
            String message = LocalDateTime.now() + "," + exception.getMessage() + "," + exception.getCause();
            printWriter.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}