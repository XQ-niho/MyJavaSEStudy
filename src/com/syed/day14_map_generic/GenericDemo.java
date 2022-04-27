package com.syed.day14_map_generic;

/**
 * @program: MyJavaSE
 * @description: 泛型
 * 作用:
 *  1.集合使用泛型来约束集合数据类型,避免类型安全问题
 *  2.泛型类/泛型接口,可以通过泛型动态改变属性的数据类型
 *  3.泛型方法,方法返回类型参数是根据泛型定义来动态改变的
 * @author: USER
 * @create: 2022-03-29
 */
public class GenericDemo<X, Y, Z> {
    private X x;
    private Y y;
    private Z z;

    public GenericDemo() {
    }

    public GenericDemo(X x, Y y, Z z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public Y getY() {
        return y;
    }

    public void setY(Y y) {
        this.y = y;
    }

    public Z getZ() {
        return z;
    }

    public void setZ(Z z) {
        this.z = z;
    }

    /**泛型方法: 方法返回类型参数是根据泛型定义来动态改变的*/
    public X method(){
        return null;
    }

    public static void main(String[] args) {
        GenericDemo<Integer,Integer,String> demo1 = new GenericDemo<>(1,11,"AA");
        GenericDemo<String,String,String> demo2 = new GenericDemo<>("1","11","AA");
    }
}
