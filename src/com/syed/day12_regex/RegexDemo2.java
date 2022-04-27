package com.syed.day12_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description：Java内置正则表达式API
 *
 * 1.String类中的matches()方法,可以进行精确匹配,返回类型boolean(用的较多)
 *
 * 2.java.util.regex.Pattern    正则表达式模板类
 *   java.util.regex.Matcher    正则表达式匹配器
 *   可以进行精确匹配和模糊匹配,但是一般我们是模糊匹配使用居多,精确匹配的写法不如String来的方便.
 *
 * @author USER
 *
 */
public class RegexDemo2 {
    public static final Pattern PATTERN = Pattern.compile("[A-Za-z]+");

    public static void main(String[] args) {
        //Pattern pattern = Pattern.compile("[A-Za-z]+");
        Matcher matcher = PATTERN.matcher("我always为自己感到自豪，因为我为自己选择了一个最感兴趣的专业。" +
                "我一直为自己感到骄傲，因为我积极的心态让我的大学生活非常充实。我热爱营销，更钟爱策划。所以我dream穿上高档男装，" +
                "梦想有自己的书房，梦想有自己的一间office，梦想有自己的一台高端笔记本电脑，梦想我有自己的一个企业。" +
                "梦想有自己的一个天然游泳pool，梦想有自己的天然农场，梦想有自己的豪华car，梦想有自己的一栋别墅，更梦想有一个漂亮又忠贞的wife。");
        //模糊匹配
        while (matcher.find()) {
            //获取匹配内容所在的起始下标和结束下标
            System.out.println("[" + matcher.start() + "," + matcher.end() + "]: " + matcher.group());
        }
    }
}
