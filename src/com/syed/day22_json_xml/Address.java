package com.syed.day22_json_xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 * @Description
 * @createTime 2022/4/11 15:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String province;
    private String city;
    private String area;
}
