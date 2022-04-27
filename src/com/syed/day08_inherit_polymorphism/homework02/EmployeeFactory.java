package com.syed.day08_inherit_polymorphism.homework02;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 14:00
 */
public class EmployeeFactory {
    public static final int HOURLY_EMPLOYEE = 1;
    public static final int SALARLED_EMPLOYEE = 2;
    public static final int SALAES_EMPLOYEE = 3;
    public static final int BASED_PLUS_EMPLOYEE = 4;

    public static Employee getEmployee(int type){
        Employee employee = null;
        switch (type){
            case HOURLY_EMPLOYEE:
                employee = new HourlyEmployee();
                break;
            case SALARLED_EMPLOYEE:
                employee = new SalarledEmployee();
                break;
            case SALAES_EMPLOYEE:
                employee = new SalesEmployee();
                break;
            case BASED_PLUS_EMPLOYEE:
                employee = new BasedPlusSalesEmployee();
                break;
            default:
                System.out.println("参数有误");
        }
        return employee;
    }

}
