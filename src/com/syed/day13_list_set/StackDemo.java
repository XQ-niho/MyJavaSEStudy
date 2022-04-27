package com.syed.day13_list_set;

import java.util.Stack;

/**
 * @program: MyJavaSE
 * @description: java.util.Stack 继承了java.util.Vector
 * @author: USER
 * @create: 2022-03-28
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        //入栈
        stack.push(10);
        stack.push(20);
        stack.push(30);
        //出栈
        stack.pop();
        //查看栈顶元素
        Integer topElem = stack.peek();

        stack.forEach(System.out::println);

        StackDemo stackDemo = new StackDemo();
        System.out.println(stackDemo.parenthesisMatch("()[]{}"));
    }

    /**
     * 括号匹配
     * @param str 括号字符串
     * @return 是否匹配
     */
    public boolean parenthesisMatch(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
