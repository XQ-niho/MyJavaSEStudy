package com.syed.phasetest.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: MyJavaSEStudy
 * @description:
 * @author: USER
 * @create: 2022-04-29
 */
@Data
public class StockQueryParam implements Serializable {
    private static final long serialVersionUID = 2753756235153233075L;

    /**股票名称*/
    private String stockName;

    /**开始时间*/
    private String startDate;

    /**结束时间*/
    private String endDate;

    /**分页的页码*/
    private Integer pageNo;
}
