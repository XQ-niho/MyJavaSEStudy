package com.syed.phasetest.vo;

import com.syed.phasetest.constans.OperationType;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: MyJavaSEStudy
 * @description: 客户端用于传输数据到服务端的对象（大致结构）
 * 客户端每次要服务端做操作的时候就向服务端传递一个TransformData对象
 * @author: USER
 * @create: 2022-04-29
 */
@Data
public class TransformData<T> implements Serializable {
    private static final long serialVersionUID = 5580769514134450378L;
    /**
     * 客户端要服务端进行操作的类型（例如：获取某个股票在某个时间区间中的信息）
     * 这里的OperationType为一个枚举类型，里面罗列出所有可能要进行的操作
     * 服务端根据这个值可以确定是什么操作，然后执行对应的操作
     */
    private OperationType operationType;
    /**
     * data表示在客户端要求服务端进行某个操作时要携带的数据信息
     * 例如执行"获取某个股票在某个时间区间中的信息"操作时，需要将股票名称和时间区间提交给服务端
     */
    private T data;
}
