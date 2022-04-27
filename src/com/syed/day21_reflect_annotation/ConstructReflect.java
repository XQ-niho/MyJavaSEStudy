package com.syed.day21_reflect_annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * @program: MyJavaSE
 * @description: Java反射操作构造方法
 * @author: USER
 * @create: 2022-04-11
 */
public class ConstructReflect {
    public static void main(String[] args) {
        Class<Point> pointClass = Point.class;

        //获取类中所有公共构造方法
        Constructor<?>[] constructors = pointClass.getConstructors();
        //获取所有的构造方法
        Constructor<?>[] declaredConstructors = pointClass.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            //获取构造方法的修饰符
            String modifier = Modifier.toString(constructor.getModifiers());
            //获取构造方法名字
            String constructorName = constructor.getName();
            //获取构造方法参数数据类型
            Class[] parameterTypes = constructor.getParameterTypes();

            String result = modifier + " " + constructorName.substring(constructorName.lastIndexOf(".") + 1) + "(";
            if (parameterTypes != null && parameterTypes.length > 0) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    result += i == parameterTypes.length - 1 ? parameterTypes[i].getName() : parameterTypes[i].getName() + ",";
                }
            }
            result += "){}";
            System.out.println(result);
        }


        /**
         * 反射创建对象
         */
        try {
            //1、调用空参构造方法
            //JDK9.0开始过时
            Point point1 = pointClass.newInstance();

            //Point point2 = pointClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
            Point point2 = pointClass.getConstructor().newInstance();
            System.out.println(point1);
            System.out.println(point2);

            //2、调用有参构造创建对象
            //Point point3 = pointClass.getConstructor(new Class[]{int.class, int.class}).newInstance(new Object[]{10, 20});
            Point point3 = pointClass.getConstructor(int.class, int.class).newInstance(10, 20);
            System.out.println(point3);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
