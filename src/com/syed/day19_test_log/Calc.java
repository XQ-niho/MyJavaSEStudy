package com.syed.day19_test_log;

import org.apache.log4j.Logger;

/**
 * description：
 *
 * @author Administrator
 * @date 2022/4/8 10:44
 */
public class Calc {
    Logger logger = Logger.getLogger(Calc.class);

    public int div(int a, int b) {
        int r = 0;
        try {
            r = a / b;
        } catch (Exception e) {
            //自定义日志工具操作
            //MyLogUtil.log(e);
            //使用日志框架,配置文件需放在rsc下
            logger.error("除数为0!");
        }
        return r;
    }
}