package com.syed.day13_list_set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @program: MyJavaSE
 * @description: java.util.TreeSet,它是一个可以自定义排序规则的HashSet集合
 * 实现了SortedSet接口
 * 特点:
 * 有序(自定义排序规则),不可重复
 * @author: USER
 * @create: 2022-03-28
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        /**
         *  TreeSet排序规则
         *  方式一:要求存入集合的对象都必须实现java.lang.Comparable接口,并且重写compareTo(o)方法,
         *  该方法是通过正零负来比较大等小的情况.
         *  包装类,字符串,日期等类型就是因为已经实现了该接口并且重写了该方法,所以才可以直接排序,
         *  自定义对象类型也可以通过该方式来实现排序规则
         *
         *  注意:
         *  由于Set集合排重的特点,排序规则指定时最好定义多重排序规则,否则如果排序规则比较单一,
         *  在数值相同的情况下,会导致比较的两个对象丢失
         *
         *  缺点:
         *  排序规则一旦确定,就无法改变,即无法在系统中按照自己的意愿来动态调整排序规则,不灵活!!!
         *
         *
         *  方式二: 在TreeSet构造方法的参数传入比较器对象(同Collections.sort()方法的第二个参数)来动态指定排序规则,
         *  比较器对象需要实现java.util.Comparator接口,并且重写compare(o1,o2)方法
         */
        Integer.compare(1, 3);

        TreeSet<String> set = new TreeSet<>();
        set.add("BB");
        set.add("AA");
        set.add("CC");
        set.add("EE");
        set.add("DD");
        set.add("BB");
        System.out.println(set);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        Employee e1 = new Employee("AA", 25, 10000.0);
        Employee e2 = new Employee("CC", 24, 12000.0);
        Employee e3 = new Employee("BB", 21, 12000.0);
        Employee e4 = new Employee("DD", 23, 17000.0);
        Employee e5 = new Employee("EE", 29, 16000.0);
        Employee e6 = new Employee("AA", 25, 10000.0);

        //JDK8.0之前
        /*TreeSet<Employee> employees = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int result = o1.getSalary().compareTo(o2.getSalary());
                if (result == 0) {
                    result = o1.getAge().compareTo(o2.getAge());
                }
                return result;
            }
        });*/

        //JDK8.0 lambda
//        TreeSet<Employee> employees = new TreeSet<>((o1, o2) -> {
//            int result = o1.getSalary().compareTo(o2.getSalary());
//            if (result == 0) {
//                result = o1.getAge().compareTo(o2.getAge());
//            }
//            return result;
//        });

        //JDK8.0,lambda ,并且是顺序情况才可以使用
        //TreeSet<Employee> employees = new TreeSet<>(Comparator.comparingDouble(Employee::getSalary).thenComparingInt(Employee::getAge));


        //实现动态排序（创建一个Comparator工厂类）
        Comparator<Employee> c = EmpComparatorFactory.getComparator(EmpComparatorFactory.SAL_MIN_TO_MAX);
        TreeSet<Employee> employees = new TreeSet<>(c);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);
        employees.forEach(System.out::println);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Employee
        //implements Comparable<Employee>
{
    private String name;
    private Integer age;
    private Double salary;

    //指定排序规则
   /* @Override
    public int compareTo(Employee o) {
        //return o.getSalary().compareTo(salary);//工资从大到小
        //return salary.compareTo(o.getSalary());//工资从小到大

        //此处也可以定制多重排序规则
        int result = o.getSalary().compareTo(salary);
        if (result == 0) {
            //工资相同按照年龄排
            result = o.getAge().compareTo(age);
            if (result == 0) {
                //年龄相同,按照名字排
                result = o.getName().compareTo(name);
            }
        }
        return result;
    }*/
}
