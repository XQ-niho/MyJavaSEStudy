package com.syed.homework.homework0325.service;

import com.syed.homework.homework0325.dao.impl.PeopleDao_Db;
import com.syed.homework.homework0325.entity.People;
import com.syed.homework.homework0325.entity.Student;

import java.time.LocalDate;

import static com.syed.homework.homework0325.factory.PeopleFactory.STUDENT;
import static com.syed.homework.homework0325.factory.PeopleFactory.getPeople;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-27
 */
public class PeopleService {
    PeopleDao_Db dao = PeopleDao_Db.getInstance();

    private static PeopleService peopleService = new PeopleService();

    private PeopleService() {
    }

    public static PeopleService getPeopleService(){
        return peopleService;
    }

    /**
     * 添加学生
     * @param name 姓名
     * @param age 年龄
     * @param date 入学年月
     * @return 添加的学生
     */
    public People addStudent(String name, Integer age, LocalDate date){
        People people = getPeople(STUDENT);
        people.setName(name);
        people.setAge(age);
        ((Student)people).setEnterSchoolDate(date);
        dao.insertPeople(people);
        return people;
    }

    /**
     *删除学生
     * @param id 学号
     * @return 被删除的学生
     */
    public People deleteStudent(Long id){
        return dao.deletePeople(id);
    }

    /**
     * 修改学生信息
     * @param id 学生学号
     * @return 被修改的学生
     */
    public People changeStudentInfo(Long id,String name, Integer age){
        return dao.updatePeopleInfo(id,name,age);
    }

    /**
     * 查看所有学生
     */
    public void showAllStudent(){
        dao.selectAllPeoples(STUDENT);
    }
}
