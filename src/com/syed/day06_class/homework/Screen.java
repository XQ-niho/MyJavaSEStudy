package com.syed.day06_class.homework;

/**
 * @author qiu
 * @Description:
 * @date 2022/3/15 15:18
 */
public class Screen {

    String type;
    int size;
    String brand;

    public Screen() {
    }

    public Screen(String type, int size, String brand) {
        this.type = type;
        if(size == 17 || size == 23 || size == 19 || size == 25){
            this.size = size;
        }else{
            this.size = 17;
        }
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "type='" + type + '\'' +
                ", size=" + size +
                ", brand='" + brand + '\'' +
                '}';
    }
}
