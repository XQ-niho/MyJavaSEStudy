package com.syed.day14_map_generic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: MyJavaSE
 * @description: java.util.Properties类
 *
 * 作用:
 * 1.用来获取系统属性键值,通过这些属性来进行代码兼容性判断
 * 2.(极其重要) 用来加载properties配置文件的信息
 *      Java项目一般都有配置文件,配置文件有很多的类型,比如.xml,.properties,.yml...
 *
 *      properties配置文件,后缀名为.properties的特殊文本文件,其中书写的就是属性键值
 *      key=value
 *
 * 注意: Properties集合在使用时无需指定泛型!!!
 *
 * @author: USER
 * @create: 2022-03-29
 */
public class PropertiesDemo {
    public static void main(String[] args) {
        //系统属性键值集合
        //Properties properties = System.getProperties();
        /**
         * 通过系统的key来获取value
         * os.arch      系统架构
         * user.name    用户名
         * os.name      操作系统名字
         */
        /*String arch = properties.getProperty("os.arch");
        System.out.println(arch);

        String name = properties.getProperty("user.name");
        System.out.println(name);

        String osname = properties.getProperty("os.name");
        System.out.println(osname);

        //罗列打印所有系统属性键值
        properties.list(System.out);*/

        //加载properties文件
        Properties properties = new Properties();

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/syed/config/db_config.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(username);
        System.out.println(password);
    }
}
