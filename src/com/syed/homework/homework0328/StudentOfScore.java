package com.syed.homework.homework0328;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-28
 */

public class StudentOfScore {
    public static void main(String[] args) {
        StudentOfScore studentOfScore = new StudentOfScore();
        studentOfScore.scoreSort();
    }

    public void scoreSort() {
        List<Student> students = new ArrayList<>();
        String name = "A";
        for (int i = 0; i < 40; i++) {
            Student student = new Student(name + i);
            students.add(student);
        }
        students.sort((o1, o2) -> {
            int result = o2.getScore().compareTo(o1.getScore());
            if (result != 0) {
                return result;
            }
            return o1.getId().compareTo(o2.getId());
        });

        students.forEach(System.out::println);
    }

    public static Integer getRandomScore() {
        return (int) (Math.random() * 51) + 50;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student {
    private Integer id;
    private static Integer stuID = 180201;
    private String name;
    private Integer score;

    public Student(String name) {
        this.name = name;
        this.id = stuID++;
        this.score = StudentOfScore.getRandomScore();
    }

    @Override
    public String toString() {
        return "学号：" + id +
                ", 姓名：" + name +
                ", 成绩：" + score +
                '}';
    }
}
