package com.syed.homework.homework0329;

import java.util.List;

/**
 * description：单词子类
 * @author Administrator
 * @date 2022/3/21 15:59
 */
public class Word extends Base{
    /**特有属性:首字母*/
    private char firstLetter;

    public Word() {
    }

    public Word(String en, List<String> cns) {
        super(en, cns);
        //英文确定时,首字母即确定了,则自动来赋值
        this.firstLetter = en.charAt(0);
    }

    public char getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(char firstLetter) {
        this.firstLetter = firstLetter;
    }
}