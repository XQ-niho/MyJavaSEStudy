package com.syed.phasetest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @program: MyJavaSEStudy
 * @description:
 * @author: USER
 * @create: 2022-04-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock implements Serializable {
    private static final long serialVersionUID = -2303670462165121198L;
    /**
     * 股票名称
     */
    private String socketName;

    /**
     * 股票日期
     */
    private LocalDate date;

    /**
     * 当日最高价格
     */
    private BigDecimal minPrice;

    /**
     * 当日最低价格
     */
    private BigDecimal maxPrice;

    /**
     * 当日成交量
     */
    private Long volume;
}
