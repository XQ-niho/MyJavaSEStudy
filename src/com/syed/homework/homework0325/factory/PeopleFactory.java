package com.syed.homework.homework0325.factory;

import com.syed.homework.homework0325.config.IConstants;
import com.syed.homework.homework0325.entity.People;
import com.syed.homework.homework0325.entity.Student;
import com.syed.homework.homework0325.entity.Teacher;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-27
 */
public class PeopleFactory implements IConstants {

    public static People getPeople(int type){
        People people = null;
        switch (type){
            case TEACHER:
                people = new Teacher();
                break;
            case STUDENT:
                people = new Student();
                break;
            default:
                System.out.println("输入参数有误！！！");
        }
        return people;
    }
}
