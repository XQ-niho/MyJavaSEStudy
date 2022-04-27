package com.syed.day19_test_log;

import org.junit.Test;

/**
 * description：代码测试覆盖率
 * @author Administrator
 * @date 2022/4/8 10:45
 */
public class TestCalc {

    Calc calc = new Calc();

    @Test
    public void div1() {
        int div = calc.div(9, 3);
        System.out.println(div);
    }

    @Test
    public void div2() {
        int div = calc.div(9, 0);
        System.out.println(div);
    }
}