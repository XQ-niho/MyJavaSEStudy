package com.syed.day07.v2;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @description: 业务类
 * @author: qiu
 * @date: 2022/3/16 16:12
 */
public class EmployeeService {
    /**
     * 添加下属
     * @param manage 上司
     * @param employee 员工
     */
    public void addEmp(Employee manage, Employee employee){
        if(manage.getEmployees() != null){
            manage.setEmployees(ArrayUtils.add(manage.getEmployees(),employee));
        }else{
            System.err.print("无权添加员工");
        }
    }

    /**
     * 显示上司的下属
     * @param manage 上司
     */
    public void showEmp(Employee manage){
        if(manage.getEmployees() != null){
            for(Employee e: manage.getEmployees()){
                System.out.println(e.getId()+" "+e.getName());
            }
        }else{
            System.out.println("没有员工");
        }
    }

    /**
     * 获得下属数量
     * @param manage 上司
     * @return 下属数量
     */
    public int getEmpCount(Employee manage){
        int count = 0;
        if(manage.getEmployees() != null){
            count =  manage.getEmployees().length;
        }
        return count;
    }
}
