package com.syed.day07.v2;

/**
 * @description: 测试类
 * @author: qiu
 * @date: 2022/3/16 16:16
 */
public class TestEmp {
    public static void main(String[] args) {
        Employee manage = new Employee(0,"Bob",10000,new Employee[]{});
        Employee employee = new Employee(1,"jack",2000);
        Employee employee1 = new Employee(2,"Ross",3000);

        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmp(manage,employee);
        employeeService.addEmp(manage,employee1);

        employeeService.showEmp(manage);

        System.out.println(employeeService.getEmpCount(manage));

    }
}
