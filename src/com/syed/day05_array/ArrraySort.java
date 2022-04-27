package com.syed.day05_array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author qiu
 * @Description: 数组排序
 * @date 2022/3/11 15:28
 */
public class ArrraySort {
    public static void main(String[] args) {
        int[] intArr = {2, 7, 3, 3, 2, 4};

        String[] number = {"5", "6", "5", "4"};

        String[] worder = {"你", "我", "他"};

        Arrays.sort(intArr);
        Arrays.sort(number);
        Arrays.sort(worder);

        //从大到小排序
        //基本类型需要提升为包装类才可以使用
//      Arrays.sort(intArr, Collections.reverseOrder());
        Arrays.sort(number, Collections.reverseOrder());
        Arrays.sort(worder, Collections.reverseOrder());

        //按照指定的規則排序
        Student s1 = new Student("AA", 24, 60.0);
        Student s2 = new Student("DD", 27, 70.0);
        Student s3 = new Student("EE", 19, 85.0);

        Student[] students = new Student[]{s1, s2, s3};

        //
        Arrays.sort(students, Comparator.comparing(Student::getAge));

        //默认从小到大
        //lambda表达式
        Arrays.sort(students, (o1, o2) -> o1.getAge().compareTo(o2.getAge()));

        //默认从小到大
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        System.out.println(Arrays.toString(students));
    }
}

class Student {
    private String name;
    private Integer age;
    private Double score;

    public Student() {
    }

    public Student(String name, Integer age, Double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
