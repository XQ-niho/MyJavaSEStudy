package com.syed.day22_json_xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

/**
 * @author Administrator
 * @Description
 * @createTime 2022/4/11 15:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private Address address;
}
