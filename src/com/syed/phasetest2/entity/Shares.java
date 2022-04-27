package com.syed.phasetest2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Shares {
    private String name;
    private LocalDate date;
    private Double lowestPrice;
    private Double highestPrice;
    private Long volume;
}
