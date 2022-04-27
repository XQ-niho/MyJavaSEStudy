package com.syed.homework.homework0325.dao.impl;

import com.syed.homework.homework0325.config.IConstants;
import com.syed.homework.homework0325.dao.PeopleDao;
import com.syed.homework.homework0325.entity.People;
import com.syed.homework.homework0325.entity.Student;
import com.syed.homework.homework0325.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-27
 */
public class PeopleDao_Db implements PeopleDao, IConstants {

    private List<People> peoples = new ArrayList<>();

    private static PeopleDao_Db peopleDao_db = new PeopleDao_Db();

    private PeopleDao_Db() {
    }

    public static PeopleDao_Db getInstance() {
        return peopleDao_db;
    }


    @Override
    public void selectAllPeoples(int type) {
        for (int i = 0; i < peoples.size(); i++) {
            People people = peoples.get(i);
            if (type == STUDENT && people instanceof Student) {
                System.out.println(people);
            } else if (type == TEACHER && people instanceof Teacher) {
                System.out.println(people);
            }
        }
    }

    @Override
    public People insertPeople(People people) {
        peoples.add(people);
        return people;
    }

    @Override
    public People deletePeople(Long id) {
        People peo = null;
        for (int i = 0; i < peoples.size(); i++) {
            if (peoples.get(i) instanceof Student) {
                Student stu = (Student) peoples.get(i);
                if (stu.getStuId().equals(id)) {
                    peo = peoples.remove(i);
                }
            }
        }
        return peo;
    }

    @Override
    public People updatePeopleInfo(Long id, String name, Integer age) {
        People peo = null;
        for (int i = 0; i < peoples.size(); i++) {
            peo = peoples.get(i);
            if (peo instanceof Student && ((Student) peo).getStuId().equals(id)) {
                peo.setName(name);
                peo.setAge(age);
            }
        }
        return peo;
    }
}
