package com.syed.util;

import java.util.List;

/**
 * @program: MyJavaSE
 * @description: 根据元素删除ArrayList中出现的所有元素
 * @author: USER
 * @create: 2022-03-25
 */
public class DeleteArrayListElement {
    public static void main(String[] args) {

    }

    public void deleteByElement(List<Integer> list, Integer elem) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals(elem)) {
                list.remove(i);
            }
        }
    }
}
