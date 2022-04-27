package com.syed.day15_exception;

/**
 * @program: MyJavaSE
 * @description: 自定义异常
 * @author: USER
 * @create: 2022-03-30
 */
public class ExceptionOfCustom extends Exception{
    public ExceptionOfCustom() {
    }

    public ExceptionOfCustom(String message) {
        super(message);
    }

    public ExceptionOfCustom(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionOfCustom(Throwable cause) {
        super(cause);
    }

    public ExceptionOfCustom(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
