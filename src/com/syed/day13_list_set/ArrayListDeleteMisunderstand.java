package com.syed.day13_list_set;

import cn.hutool.core.collection.CollectionUtil;

import java.util.Iterator;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description: 集合删除细节
 * @author: USER
 * @create: 2022-03-26
 */
public class ArrayListDeleteMisunderstand {
    public static void main(String[] args) {
        List<Integer> list = CollectionUtil.newArrayList(5, 5, 1, 2, 3, 5, 4, 2, 5);
        ArrayListDeleteMisunderstand demo = new ArrayListDeleteMisunderstand();
        demo.deleteElement(list, 5);
        list.forEach(System.out::println);
    }

    /**
     * 删除集合元素
     */
    public void deleteElement(List<Integer> list, Integer target) {
        /**
         * for版本
         * 错误: 如果删除的元素是相邻的,则前一个可以删除,而后一个删除失败
         * 原因: 删除元素后,所有元素会向前移动重置下标,而循环递增是,i继续往后,所以相当于错开了删除的元素后一个元素的验证
         * 解决:
         * 1.i--
         * 2.i++换位置
         * 3.反向删除(最优解)
         */
        // 出错
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                list.remove(i);
            }
        }*/

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals(target)) {
                list.remove(i);
            }
        }

        /**
         * 迭代器版本
         * 错误原因: 集合迭代器不支持并发操作,否则会抛出并发操作异常: java.util.ConcurrentModificationException
         * 解决方案:
         */
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(next.equals(target)){
                //不能调用集合的删除方法
                //list.remove(next);

                //调用迭代器的删除方法,它会同步映射集合中
                iterator.remove();
            }
        }
    }
}
