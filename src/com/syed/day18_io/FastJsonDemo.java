package com.syed.day18_io;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;

/**
 * @program: MyJavaSE
 * @description: 使用FastJson组件来实现Java对象和JSON数据的相互转换
 * JSON,JavaScript Object Notation, JS 对象简谱,是一种轻量级的数据交换格式
 *
 * JSON的格式:
 * 单个对象     {"name":"admin1","age":25}
 * 多个对象     [{"name":"admin2","age":22},{"name":"admin3","age":18}]
 *
 * 混合对象
 *             {"name":"admin","age": 26,"address": [{"province":"江苏","city":"苏州"},{"province":"江西","city":"南昌"}]}
 *
 * 阿里巴巴提供了FastJson工具帮助我们快速转换Java对象和JSON数据
 *
 * //把JSON字符串转换成Java对象(单个)
 * JSON.parseObject(studentStr, Student.class);
 *
 * //把JSON字符串转换成Java对象(多个)
 * List<Student> students = JSON.parseArray(studentStr, Student.class);
 *
 * //把Java对象转换成JSON字符串
 * String jsonString = JSON.toJSONString(student);
 *
 * @author: USER
 * @create: 2022-04-07
 */
public class FastJsonDemo {
    public static void main(String[] args) {
        //单个对象
        /*String studentStr = "{\"name\":\"admin\",\"age\":25}";
        //把JSON字符串转换为Java对象
        Student student = JSON.parseObject(studentStr, Student.class);
        System.out.println(student);

        //把Java对象转换为JSON字符串
        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);*/

        //数组/集合对象
        /*String studentStr = "[{\"name\":\"admin2\",\"age\":22},{\"name\":\"admin3\",\"age\":18}]";
        List<Student> students = JSON.parseArray(studentStr, Student.class);
        students.forEach(System.out::println);

        String jsonString = JSON.toJSONString(students);
        System.out.println(jsonString);*/

        String studentStr = "{\"name\":\"admin\",\"age\": 26,\"address\": [{\"province\":\"江苏\",\"city\":\"苏州\"},{\"province\":\"江西\",\"city\":\"南昌\"}]}";
        Student student = JSON.parseObject(studentStr, Student.class);
        System.out.println(student);

    }
}

@Data
class Student{
    private String name;
    private Double age;
    private List<Address> address;
}

@Data
class Address{
    private String province;
    private String city;
}

