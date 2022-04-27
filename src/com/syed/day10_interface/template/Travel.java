package com.syed.day10_interface.template;

/**
 * @description: 23中设计模式之一:模板设计模式
 * @author: qiu
 * @date: 2022/3/21 10:51
 */
public abstract class Travel {

    /**
     * 去
     */
    public abstract void go();

    /**
     * 玩
     */
    public abstract void play();

    /**
     * 回
     */
    public abstract void back();

    /**
     * 定制顶级业务流程
     * */
    public final void topMethod(){
        go();
        play();
        back();
    }

}
