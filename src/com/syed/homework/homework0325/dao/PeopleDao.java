package com.syed.homework.homework0325.dao;

import com.syed.homework.homework0325.entity.People;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-27
 */
public interface PeopleDao {


    void selectAllPeoples(int type);

    People insertPeople(People student);

    People deletePeople(Long id);

    People updatePeopleInfo(Long id,String name, Integer age);

}
