package com.syed.homework;

import com.syed.util.TextInputUtil;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/23 19:33
 */
public class StringHomework {
    public static void main(String[] args) {
        StringHomework stringHomework = new StringHomework();
        System.out.println(stringHomework.subStringAppear("22222","22"));

    }

    /**
     * 加密手机号
     *
     * @param phone 手机号
     * @return 加密手机号
     */
    public String encryptionTel(String phone) {
        return phone.replace(phone.substring(3, 7), "****");
    }

    /**
     * 加密姓名
     *
     * @param name 姓名
     * @return 加密后姓名
     */
    public String encryptionName(String name) {
        String nameOfEncryption = name.substring(0, 1);
        for (int i = 1; i < name.length(); i++) {
            nameOfEncryption += "*";
        }
        return nameOfEncryption;
    }

    /**
     * 统计个字符
     * @param s 字符串
     */
    public void countKindOfChar(String s) {
        int numberCount = 0, charCount = 0, blackCount = 0, otherCount = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                numberCount++;
            } else if (chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z') {
                charCount++;
            } else if (chars[i] == ' ') {
                blackCount++;
            } else {
                otherCount++;
            }
        }
        System.out.println("数字有：" + numberCount + "个"
                + "字母有：" + charCount + "个"
                + "空格有：" + blackCount + "个"
                + "其他有：" + otherCount + "个"
        );

    }

    /**
     * 判断回文
     * @param target 目标字符串
     * @return 是否回文
     */
    public boolean isPlindrome(String target){
        for(int i = 0; i < target.length() / 2; i++){
            if(target.charAt(i) != target.charAt(target.length() - i -1)){
                return false;
            }
        }
        return true;
    }

    /**
     * 将输入的任意0-999的整数全部补全为三位数输出(不足三位补0)
     * @param number 0-999的整数
     * @return 三位数输出
     */
    public String to3Emic(int number) {
        String str = String.valueOf(number);
        if (str.length() == 1) {
            str = "00" + str;
        } else if (str.length() == 2) {
            str = "0" + str;
        }
        return str;
    }

    /**
     * 字串在字符串中出现的次数
     * @param originalString 源字符串
     * @param subString 字串
     * @return 出现次数
     */
    public int subStringAppear(String originalString, String subString) {
        int count = 0;
        int lastIndexAppear = originalString.length() - subString.length();
        for (int i = 0; i <= lastIndexAppear; ) {
            int appearIndex = originalString.indexOf(subString, i);
            if (appearIndex != -1) {
                count++;
                i = originalString.indexOf(subString, i) + 1;
            } else {
                return count;
            }
        }
        return count;
    }

    /**
     * 判断邮箱是否合法
     * @param email 邮箱字符串
     * @return 是否合法
     */
    public boolean validEmail(String email) {
        String target1 = "@";
        String target2 = ".";

        if (!email.contains(target1) || !email.contains(target2)) {
            return false;
        }

        if (email.indexOf(target1) != email.lastIndexOf(target1) || email.indexOf(target2) != email.lastIndexOf(target2)) {
            return false;
        }

        if (email.indexOf(target1) > email.indexOf(target2)) {
            return false;
        }

        for (int i = 0; i < email.indexOf(target1); i++) {
            if (((email.charAt(i) >= 'A' && email.charAt(i) <= 'Z') || (email.charAt(i) >= 'a' && email.charAt(i) <= 'z'))) {
                return false;
            }
        }
        return true;
    }


}
