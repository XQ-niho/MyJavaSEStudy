package com.syed.phasetest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @program: MyJavaSEStudy
 * @description:
 * @author: USER
 * @create: 2022-04-21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @FieldNameAnnotation(fieldName = "姓名")
    private String name;
    @FieldNameAnnotation(fieldName = "年龄")
    private Integer age;
    @FieldNameAnnotation(fieldName = "生日")
    private LocalDate birthday;

    @Override
    public String toString() {
        return name + "\t\t" + age + "\t\t" + birthday;
    }
}
