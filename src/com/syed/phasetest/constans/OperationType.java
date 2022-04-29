package com.syed.phasetest.constans;

import java.io.Serializable;

/**
 * @program: MyJavaSEStudy
 * @description: 定义所有操作的枚举类型
 * @author: USER
 * @create: 2022-04-29
 */
public enum OperationType implements Serializable {
    //枚举常量
    GET_STOCK_BY_CONDITION(1, "某个股票在某个时间区间中的信息"),
    GET_STOCK_BY_CONDITION_PAGE(2, "某个股票在指定时间区间的信息，结果进行分页显示"),
    GET_MOST_STEADY_STOCK_NAME(3, "获取成交量最稳定的股票名称"),
    EXIT(4, "退出系统");

    /**
     * 序号
     */
    private int order;

    /**
     * 操作的具体描述
     */
    private String description;

    OperationType(int order, String desc) {
        this.order = order;
        this.description = desc;
    }
}
