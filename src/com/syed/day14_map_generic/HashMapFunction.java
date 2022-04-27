package com.syed.day14_map_generic;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: MyJavaSE
 * @description: 按汽车品牌分类
 * @author: USER
 * @create: 2022-03-29
 */
public class HashMapFunction {

    public Map<String, List<Car>> categoryCar(List<Car> carList) {
        Map<String, List<Car>> mapCars = null;
        if (carList != null && carList.size() > 0) {
            mapCars = new HashMap<>();
            for (Car car : carList) {
                if (mapCars.containsKey(car.getBrand())) {
                    mapCars.get(car.getBrand()).add(car);
                } else {
                    List<Car> subList = new ArrayList<>();
                    subList.add(car);
                    mapCars.put(car.getBrand(), subList);
                }
            }
        }
        return mapCars;
    }
}

@Data
class Car {
    private String brand;
    private String type;
    private Double price;
}


