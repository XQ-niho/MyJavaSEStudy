package com.syed.day16_enum_innerclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-31
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private EnumOfGender gender;
}
