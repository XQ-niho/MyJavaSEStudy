package com.syed.homework.homework325;


import cn.hutool.core.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;

/**
 * @author qiu
 * @Description: 完全数
 * @date 2022/3/14 16:24
 */
public class BeforeHomework {
    public static void main(String[] args) {
        BeforeHomework beforeHomework = new BeforeHomework();
//        System.out.println(judgeNumber(6));
//        System.out.println(monkeyPeach(1));
//        System.out.println(beforeHomework.getRandomNums());
//        System.out.println(get32Byte());
//        beforeHomework.wordCount(new String[]{"qwe","qwe","hello"});
        beforeHomework.printDateOfMonth(2022, 2);
    }

    /**
     * 判断一个数是否是完数
     *
     * @param num
     * @return
     */
    public boolean judgeNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    /**
     * 求和：  5！+ 4！+3! + 2! + 1!
     *
     * @param num
     * @return
     */
    public  int factorialSum(int num) {
        if (num == 1 || num == 0) {
            return 1;
        }
        return num * factorialSum(num - 1);
    }

    /**
     * 猴子吃桃问题
     *
     * @param day
     * @return
     */
    public  int monkeyPeach(int day) {
        if (day == 10) {
            return 1;
        }
        return (monkeyPeach(day + 1) + 1) * 2;
    }

    /**
     * 写一个程序,使用数组存放99个随机数(不重复,数字为1-100之间),
     * 判断哪个数字没有被随机到?
     *
     * @return
     */
    public int getRandomNums() {

        int notAppear = 0;
        int[] randomNumbers = new int[99];
        boolean[] flag = new boolean[101];

        for (int i = 0; i < randomNumbers.length; ) {
            int numberOfRandom = (int) (Math.random() * 100) + 1;
            if (!flag[numberOfRandom]) {
                randomNumbers[i++] = numberOfRandom;
                flag[numberOfRandom] = true;
            }
        }
        for (int i = 1; i < flag.length; i++) {
            if (!flag[i]) {
                notAppear = i;
            }
        }
        return notAppear;
    }

    /**
     * 统计并排序
     * @param arr
     */
    public void wordCount(String[] arr) {

        String[] distinctWords = ArrayUtil.distinct(arr);
        Pojo pojo = null;
        Pojo[] pojos = {};
        String str = "";
        for(int i = 0; i < arr.length; i++){
            str += arr[i] + " ";
        }
        for (int i = 0; i < distinctWords.length; i++) {
            pojo = new Pojo(distinctWords[i], StringUtils.countMatches(str, distinctWords[i]));
            pojos = ArrayUtils.add(pojos, pojo);
        }
        Arrays.sort(pojos, (o1, o2) -> {
            int result = o2.getCount().compareTo(o1.getCount());
            if (result == 0) {
                result = o1.getWord().compareTo(o2.getWord());
            }
            return result;
        });

        for (Pojo pj : pojos) {
            System.out.println(pj);
        }

    }

    /**
     * 随机产生一个32位的串码字符串,字符串可以包含a-z,A-Z,0-9
     *
     * @return
     */
    public String get32Byte() {
        StringBuilder str = new StringBuilder();

        char[] chars = {'0', '1', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 0; i < 32; i++) {
            str.append(chars[(int) (Math.random() * 62)]);
        }

        return str.toString();
    }

    /**
     * 控制台打印一个日历(输入年,月两个参数),类似于Windows日历一样的效果
     *
     * @param year
     * @param month
     */
    public  void printDateOfMonth(int year, int month) {
        LocalDateTime newDateTime = LocalDateTime.of(year, month, 1, 0, 0, 0);

        int dayOfWeek = newDateTime.getDayOfWeek().getValue();
        int days = newDateTime.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();

        int count = 0;

        System.out.println("一\t二\t三\t四\t五\t六\t日");
        for (int i = 0; i < dayOfWeek - 1; i++) {
            System.out.print("\t");
            count++;
        }
        for (int i = 1; i <= days; i++) {
            System.out.print(i + "\t");
            count++;
            if (count % 7 == 0) {
                System.out.println();
            }
        }
    }
}

@Data
@AllArgsConstructor
class Pojo {
    private String word;
    private Integer count;

    @Override
    public String toString() {
        return word + "," + count;
    }
}
