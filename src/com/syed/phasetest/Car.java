package com.syed.phasetest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MyJavaSEStudy
 * @description:
 * @author: USER
 * @create: 2022-04-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car{
    @FieldNameAnnotation(fieldName = "类型")
    private String type;
    @FieldNameAnnotation(fieldName = "品牌")
    private String brand;
    @FieldNameAnnotation(fieldName = "价格")
    private Double price;

    @Override
    public String toString() {
        return type +"\t\t"+ brand +"\t\t"+  price ;
    }
}
