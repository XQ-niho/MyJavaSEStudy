package com.syed.day21_reflect_annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * @program: MyJavaSE
 * @description: 使用反射获取类的属性并且操作属性
 * <p>
 * java.lang.reflect.Constructor 表示构造方法的反射类
 * java.lang.reflect.Field       用来描述属性的反射类
 * java.lang.reflect.Modifier   表示修饰符的反射类
 * java.lang.reflect.Method     表示方法的反射类
 * java.lang.reflect.Array      表示数组的反射类
 * @author: USER
 * @create: 2022-04-11
 */
public class FieldReflect {
    public static void main(String[] args) {
        Class<Point> pointClass = Point.class;

        //获取类的公共属性
        Field[] fields = pointClass.getFields();

        //获取类的所有属性
        Field[] declaredFields = pointClass.getDeclaredFields();

        //遍历数组
        for (Field field : declaredFields) {
            //获取属性的修饰符
            String modifier = Modifier.toString(field.getModifiers());
            System.out.println(modifier);

            //获取属性的数据类型
            String typeName = field.getType().getName();
            System.out.println(typeName);

            //获取属性名称
            String fieldName = field.getName();
            System.out.println(fieldName);

            System.out.println(modifier + " " + typeName + " " + fieldName);
        }

        try {
            //获取Point类实例
            Point point = pointClass.getConstructor().newInstance();
            //获取单个指定的属性，并且操作
            //获取类中名为x的属性对象
            Field fieldX = pointClass.getDeclaredField("x");
            //注意：操作私有化成员时，需要开启权限，否则会抛出异常:java.lang.IllegalAccessException
            fieldX.setAccessible(true);
            //反射获取x属性的值，参数为point对象
            Object o = fieldX.get(point);
            System.out.println("修改前的值：" + o);

            //修改x属性的值
            fieldX.set(point, 10);
            o = fieldX.get(point);
            System.out.println("修改后的值：" + o);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
