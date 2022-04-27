package com.syed.util;

import java.util.Arrays;

/**
 * @author qiu
 * @Description: 数组工具类
 * @date 2022/3/10 16:09
 */
public class ArrayUtil{

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 4};
//        System.out.println(Arrays.toString(addElement(arr, 0, 5)));
//        System.out.println(Arrays.toString(deleteElemByIndex(arr, 0)));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 获取数组中的最大值
     *
     * @param arr 原数组
     * @return maxIndex
     */
    public static int getMaxElementIndex(int[] arr) {
        int maxIndex = 0;
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /***
     * 添加数组元素
     * @param arr 原数组
     * @param pos 添加的位置
     * @param newElem 添加的新元素
     * @return 新数组
     */
    public static int[] addElement(int[] arr, int pos, int newElem) {
        if (arr == null) {
            System.out.println("数组参数不能为空");
            return null;
        }
        if (pos < 0 || pos > arr.length) {
            return arr;
        }
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, pos);
        newArr[pos] = newElem;
        System.arraycopy(arr, pos, newArr, pos + 1, arr.length - pos);

//        for(int i = 0; i < pos; i++){
//            newArr[i] = arr[i];
//        }
//        newArr[pos] = newElem;
//
//        for(int i = pos; i < arr.length; i++){
//            newArr[i + 1] = arr[i];
//        }
        return newArr;
    }

    /***
     * 按位删除数组元素
     * @param arr 原数组
     * @param index 数组下标
     * @return 删除后的数组
     */
    public static int[] deleteElemByIndex(int[] arr, int index) {
        if (null == arr) {
            System.out.println("数组元素不能为空");
            return arr;
        }
        if (index < 0 || index >= arr.length) {
            return arr;
        }
        int[] newArr = new int[arr.length - 1];

        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);

//        int pos = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (i != index) {
//                newArr[pos++] = arr[i];
//            }
//        }
        return newArr;
    }

    /***
     * 按值删除数组元素
     * @param arr 原数组
     * @param targetValue 删除的目标元素
     * @return 删除后得到的新数组
     */
    public static int[] deleteElemByValue(int[] arr, int targetValue) {
        if (null == arr) {
            System.out.println("数组不能为空");
            return arr;
        }

        int commonValue = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == targetValue) {
                commonValue++;
            }
        }

        int[] newArr = new int[arr.length - commonValue];

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != targetValue) {
                newArr[index++] = arr[i];
            }
        }
        return newArr;
    }

    /**
     * 数组元素排重
     *
     * @param arr 元素组
     * @return 排重后的新数组
     */
    public static int[] noRepeatElem(int[] arr) {
        int[] newArr = new int[arr.length];
        int index = 0;

        do {
            newArr[index++] = arr[0];
            arr = deleteElemByValue(arr, arr[0]);
        } while (arr.length != 0);

        newArr = Arrays.copyOf(newArr, index);
        return newArr;
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < minIndex){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */

    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int value = arr[i];
            int j = i -1;
            while(j >= 0 && arr[j] > value){
                arr[j +1 ] = arr[j];
                j--;
            }
            arr[j +1 ] = value;
        }
    }

}
