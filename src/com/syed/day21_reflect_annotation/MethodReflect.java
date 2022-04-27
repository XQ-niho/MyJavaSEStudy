package com.syed.day21_reflect_annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @program: MyJavaSE
 * @description: 反射获取方法信息并且调用方法
 * @author: USER
 * @create: 2022-04-11
 */
public class MethodReflect {
    public static void main(String[] args) {
        try {
            //获取类实例
            Class<Point> pointClass = Point.class;
            //反射创建Point对象
            Point point = pointClass.getConstructor().newInstance();

            //获取当前类所有公共方法，包括父类继承的方法(不包括私有化方法)
            Method[] methods = pointClass.getMethods();
            //获取当前类中所有方法，包括私有方法(不包括父类方法)
            Method[] declaredMethods = pointClass.getDeclaredMethods();

            for (Method method : declaredMethods) {
                //获取方法的修饰符
                String methodModifier = Modifier.toString(method.getModifiers());
                //获取返回类型
                String returnTypeName = method.getReturnType().getName();
                //获取方法名
                String methodName = method.getName();
                //获取参数列表
                Class<?>[] parameterTypes = method.getParameterTypes();
                //编辑输出结果
                String result = methodModifier + " " + returnTypeName + " " + methodName + "(";
                if (parameterTypes != null && parameterTypes.length > 0) {
                    for (int i = 0; i < parameterTypes.length; i++) {
                        result += i == parameterTypes.length - 1 ? parameterTypes[i] : parameterTypes[i] + ",";
                    }
                }
                result += "){}";
                System.out.println(result);
            }

            //通过反射调用方法
            //1、获取void类型的空参方法
            //Method method1 = pointClass.getMethod("method1", new Class[]{});
            Method method1 = pointClass.getMethod("method1");
            //method1.invoke(point,new Object[]{});
            method1.invoke(point);

            //2、获取void类型的有参方法
            //Method method2 = pointClass.getMethod("method2", new Class[]{int.class, int.class});
            //method2.invoke(point, new Object[]{10, 20});
            pointClass.getMethod("method2", int.class, int.class).invoke(point, 10, 20);

            //3、获取有返回值的方法
            Method method3 = pointClass.getMethod("method3");
            Object returnValue = method3.invoke(point);
            System.out.println(returnValue);

            //4、获取私有化方法
            //注意：私有化方法在获取时要注意获取方式getDeclaredMethod,并且还要开启权限
            Method method4 = pointClass.getDeclaredMethod("method4");
            method4.setAccessible(true);
            method4.invoke(point);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
   }
}
