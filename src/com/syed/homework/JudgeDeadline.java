package com.syed.homework;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * @author qiu
 * @Description: 判断商品是否过期
 * @date 2022/3/7 11:24
 */
public class JudgeDeadline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品生产日期yyyy-MM-dd");
        String productionDate = scanner.nextLine();
        System.out.println("请输入商品保质期按年");
        String expirationDate = scanner.nextLine();

        LocalDate dateOfProduction = LocalDate.parse(productionDate);

        LocalDate plus = dateOfProduction.plus(Integer.parseInt(expirationDate), ChronoUnit.YEARS);

        boolean isBefore = plus.isBefore(LocalDate.now());
        if(isBefore){
            System.out.println("已过期");
        }else{
            System.out.println("没过期");
        }

    }
}