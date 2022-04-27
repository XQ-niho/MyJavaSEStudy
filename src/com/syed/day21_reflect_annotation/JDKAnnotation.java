package com.syed.day21_reflect_annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description: JDK内置注解
 *
 * * @Override    表示被修饰的方法是重写方法,这是一个检测注解,无论是否有它,只要复合规则,都是重写方法!!!
 *  *              只能用来修饰方法
 *  *
 *  * @Deprecated  表示被修饰的内容已过时,不推荐使用,注意:不推荐使用不代表不能用!!!
 *  *              可以使用在几乎所有的内容上
 *  *
 *  * @SuppressWarnings(...)      用来抑制警告信息,也可以修饰很多内容(不推荐使用,仅作了解)
 *  *
 *  *
 *  * 第三方的注解
 *  * @Data        lombok自动产生代码
 *  * @Test        单元测试
 *
 * @author: USER
 * @create: 2022-04-11
 */
//@SuppressWarnings({"unused","rawtypes","unchecked"})
//抑制当前类中所有的警告信息
@SuppressWarnings("all")
@Deprecated
public class JDKAnnotation {
    public static void main(String[] args) {
        //定义变量没有使用
        //@SuppressWarnings("unused")
        int i = 3;

        //调用了过时的方法
        new Date().getMonth();

        //使用集合没有定义泛型
        List list = new ArrayList();
    }
}


class Super{
    @Deprecated
    public void method(){

    }
}

class Sub extends Super{
    @Override
    public void method() {

    }
}
