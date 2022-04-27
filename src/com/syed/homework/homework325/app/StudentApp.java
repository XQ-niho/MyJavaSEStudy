package com.syed.homework.homework325.app;

import com.syed.homework.homework325.service.StudentService;
import com.syed.homework.homework325.util.TextInputUtil;
import com.syed.homework.homework325.view.Ui;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-27
 */
public class StudentApp {
    public static void main(String[] args) {
        int choose;
        Long id;
        Integer age;
        String name;

        Ui ui = new Ui();
        StudentService studentService = StudentService.getStudentService();

        for (; ; ) {
            ui.menu();
            choose = TextInputUtil.getInt("请选择功能：");
            switch (choose) {
                case 1:
                    name = TextInputUtil.getString("请输入姓名：");
                    age = TextInputUtil.getInt("请输入年龄：");
                    studentService.addStudent(age, name);
                    break;
                case 2:
                    id = TextInputUtil.getLong("请输入要删除的id：");
                    studentService.deleteStu(id);
                    break;
                case 3:
                    id = TextInputUtil.getLong("请输入要修改的id：");
                    name = TextInputUtil.getString("请输入修改的姓名：");
                    age = TextInputUtil.getInt("请输入修改的年龄：");
                    studentService.changeStudentInfo(id, name, age);
                    break;
                case 4:
                    studentService.showAllStudent();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("功能选择错误！！！");
            }
        }
    }
}
