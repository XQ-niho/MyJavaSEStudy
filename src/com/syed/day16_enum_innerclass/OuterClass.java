package com.syed.day16_enum_innerclass;

/**
 * @program: MyJavaSE
 * @description: 外部类
 * @author: USER
 * @create: 2022-03-31
 */
public class OuterClass {
    //外部类的普通属性
    private Integer id = 1;
    //外部类静态属性
    private static Integer guid = 10;


    /**
     * 成员内部类
     */
    //public class MethodInnerClass{
    private class MemberInnerClass {
        //内部类普通属性
        private Integer id = 2;
        //内部类静态属性
//        private static Integer guid = 20;
        //内部类的方法
        public void memberInnerMethod() {
            System.out.println(id);
            System.out.println(guid);

            //注意：内部类可以直接访问外部类成员
            //System.out.println(outerId);
            //System.out.println(outerGuid);

            //如果内部类属性和外部类属性同名，则访问时，直接访问的是内部类的属性
            //要访问外部类属性，则必须如下写法
            System.out.println(OuterClass.this.id);
            //System.out.println(OuterClass.guid);
        }

    }

    // 外部类方法
    // 提供创建内部类对象，并且调用方法
    public void outerMethod(){
        //创建成员内部类对象
        MemberInnerClass memberInnerClass = new MemberInnerClass();
        //调用内部类方法
        memberInnerClass.memberInnerMethod();
    }

    /**
     * 静态内部类
     * 把内部类当作外部类的的静态成员
     * */
    public static class StaticInnerClass{
        private Integer id = 3;
        private static Integer gudi = 30;

        public void staticInnerMethod(){
            System.out.println(id);
            System.out.println(guid);

            //注意：静态内部类可以访问外部类的静态成员！！！
            //System.out.println(OuterClass.this.id);
            System.out.println(OuterClass.guid);
        }
    }


    /**
     * 局部内部类，定义在外部类的方法中
     */
    public void outerMethod2(){
        class LocalInnerClass{
            private Integer id = 4;
            //private static Integer guid = 40;

            public void localInnerMethod(){
                System.out.println(id);
                System.out.println(guid);

                System.out.println(OuterClass.this.id);
                //System.out.println(OuterClass.guid);
            }
        }

        //创建局部内部类对象，并调用方法
        LocalInnerClass lic = new LocalInnerClass();
        lic.localInnerMethod();
    }


    /**
     * 匿名内部类，没有名字的局部内部类
     */
    public void outerMethod3(){
        new Inner(){
            private int id = 4;
            //private static int guid = 40;

            @Override
            public void method() {
                System.out.println(id);
                System.out.println(guid);

                System.out.println(OuterClass.this.id);
                //System.out.println(OuterClass.guid);
            }
        }.method();
    }

    interface Inner{
        void method();
    }
}
