package com.syed.homework.homework0328;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-28
 */
public class JosephRing {
    public static void main(String[] args) {
        JosephRing josephRing = new JosephRing();
        josephRing.getLastPeople();
    }

    public void getLastPeopleNumber() {
        int index = 0, count = 0;
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            people.add(i);
        }
        while (people.size() > 1) {
            if (index == people.size()) {
                index = 0;
            }
            count++;
            if (count == 3) {
                people.remove(index);
                count = 0;
                index--;
            }
            index++;
        }
        System.out.println(people.get(0));
    }
    public void getLastPeople(){
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            people.add(i);
        }

        while(people.size() > 1){
            for(int i =0; i < 2; i++){
                //把前两个放到最后
                people.add(people.remove(0));
            }
            //删除第三个
            people.remove(0);
        }
        System.out.println(people.get(0));
    }
}
