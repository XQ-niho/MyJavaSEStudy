package com.syed.day22_json_xml;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author Administrator
 * @Description 把JSON转换成Java对象
 * 把Java对象转换成JSON
 * @createTime 2022/4/11 15:01
 */
public class JSONParser {
    public static void main(String[] args) {
        /**
         * 读取JSON文件,并且把JSON数据转换成Java对象
         */
        String jsonStr = FileUtil.readString("com/syed/day22_json_xml/students.json", Charset.defaultCharset());
        List<Student> students = JSON.parseArray(jsonStr, Student.class);
        students.forEach(System.out::println);

        /**
         * 把Java对象转换成JSON
         */
        //JSON.toJSONString()
        //JSON.writeJSONString();
    }
}
