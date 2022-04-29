package com.syed.phasetest.service;

import com.syed.phasetest.annotation.VolumeOrder;
import com.syed.phasetest.constans.OperationType;
import com.syed.phasetest.constans.Order;
import com.syed.phasetest.entity.Stock;
import com.syed.phasetest.vo.StockQueryParam;
import com.syed.phasetest.vo.TransformData;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.io.*;
import java.math.BigDecimal;
import java.net.Socket;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static com.syed.phasetest.constans.IConstants.PATH_OF_SOCKET_DATA;
import static com.syed.phasetest.constans.IConstants.THREAD_CORE_POOL_SIZE;
import static com.syed.phasetest.constans.OperationType.*;

/**
 * @program: MyJavaSEStudy
 * @description: 服务器处理类
 * @author: USER
 * @create: 2022-04-29
 */
public class ServerHandler {

    /**
     * 用来存储数据文件中解析出来的所有股票信息的集合
     */
    private static List<Stock> stockList = new ArrayList<>();

    /**
     * 并发解析数据文件线程池
     */
    private ExecutorService handlerDataPool = Executors.newFixedThreadPool(THREAD_CORE_POOL_SIZE);

    /**
     * 客户端线程池
     */
    private ExecutorService handlerClientPool = Executors.newCachedThreadPool();

    public ServerHandler() {
        handlerAllData();
    }

    /**
     * 通过线程池去加载所有数据文件的信息并且保存到List中
     */
    private void handlerAllData() {
        File dataFile = new File(PATH_OF_SOCKET_DATA);
        if (dataFile.isDirectory()) {
            File[] files = dataFile.listFiles();
            //Stream流处理
            if (!Objects.isNull(files)) {
                Arrays.stream(files).forEach(file -> {
                    handlerDataPool.submit(() -> analyseFile(file));
                });
                //关闭线程池
                handlerDataPool.shutdown();
                while (true) {
                    //检查线程池中是否还有任务没有完成,如果还有未完成的任务,则通过死循环来阻塞后续的操作,
                    //如果全部完成,则跳出死循环。
                    if (handlerDataPool.isTerminated()) {
                        System.out.println("已经完成素有股票数据的加载,共有: " + stockList.size() + "条数据.");
                        break;
                    }
                }
            } else {
                System.out.println("暂无股票数据！！！");
            }
        }
    }

    /**
     * 解析所有文件
     */
    private void analyseFile(File file) {
        //使用commons-io组件中的FilenameUtils工具类获取文件后缀
        String suffix = FilenameUtils.getExtension(file.getName());
        if ("dat".equalsIgnoreCase(suffix)) {
            //解析dat文件
            analyseDatFile(file);
        }
        if ("csv".equalsIgnoreCase(suffix)) {
            //解析csv文件
            analyseCsvFile(file);
        }
    }

    /**
     * 解析csv文件
     */
    private void analyseCsvFile(File file) {
        try {
            List<String> stockLines = FileUtils.readLines(file, Charset.defaultCharset());
            //Stream流处理
            stockList.addAll(stockLines.stream().map(line -> {
                String[] fields = line.split("[,]");
                Stock stock = new Stock();
                stock.setSocketName(fields[0]);
                stock.setDate(LocalDate.parse(fields[1], DateTimeFormatter.ofPattern("yyyy-M-d")));
                stock.setMinPrice(new BigDecimal(fields[2]));
                stock.setMaxPrice(new BigDecimal(fields[3]));
                stock.setVolume(Long.parseLong(fields[4]));
                return stock;
            }).collect(Collectors.toList()));
            System.out.println("数据解析完毕！！！");
        } catch (IOException e) {
            System.out.println("数据解析失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * 解析dat文件
     */
    private void analyseDatFile(File file) {
        try (FileInputStream fin = new FileInputStream(file)) {
            //读取dat文件,利用commons-lang3组件进行反序列化操作
            Object obj = SerializationUtils.deserialize(fin);
            //经过反射操作以及断点解析,得到obj真正的数据类型
            List<LinkedHashMap<String, Object>> list = (List<LinkedHashMap<String, Object>>) obj;
            //Stream流解析
            stockList.addAll(list.stream().map(dataMap -> {
                Stock stock = new Stock();
                stock.setSocketName(String.valueOf(dataMap.get("stockName")));
                stock.setDate((LocalDate) dataMap.get("date"));
                stock.setMinPrice(new BigDecimal(String.valueOf(dataMap.get("minPrice"))));
                stock.setMaxPrice(new BigDecimal(String.valueOf(dataMap.get("maxPrice"))));
                stock.setVolume(Long.parseLong(String.valueOf(dataMap.get("volume"))));
                return stock;
            }).collect(Collectors.toList()));
            System.out.println("数据解析完毕！！！");
        } catch (IOException e) {
            System.out.println("数据解析失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * 每个客户端都单独开启一个线程来进行处理(多线程)
     */
    public void handlerSocket(Socket socket) {
        handlerClientPool.submit(() -> {
            while (true) {
                try (ObjectInputStream finObj = new ObjectInputStream(socket.getInputStream())) {
                    TransformData<StockQueryParam> transformData = (TransformData) finObj.readObject();
                    OperationType operationType = transformData.getOperationType();
                    //返回给客服端的信息
                    Object result = null;
                    //某个股票在某个时间区间中的信息
                    StockQueryParam sqpData = transformData.getData();
                    if (GET_STOCK_BY_CONDITION == operationType) {
                        result = printStockVolumeInfo(sqpData.getStockName(), sqpData.getStartDate(), sqpData.getEndDate());
                    }
                    //某个股票在指定时间区间的信息，结果进行分页显示
                    if (GET_STOCK_BY_CONDITION_PAGE == operationType) {
                        result = showStockInfoBetweenByPage(sqpData.getStockName(), sqpData.getStartDate(), sqpData.getEndDate(), sqpData.getPageNo());
                    }
                    //获取成交量最稳定的股票名称
                    if (GET_MOST_STEADY_STOCK_NAME == operationType) {
                        result = showMostSteadyStock();
                    }
                    //退出系统
                    if (EXIT == operationType) {
                        System.out.println("退出系统");
                        break;
                    }
                    ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream());
                    outObj.writeObject(result);
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("客户端退出...");
                    break;
                }
            }
        });
    }

    private Stock showMostSteadyStock() {
        return null;
    }

    private List<Stock> showStockInfoBetweenByPage(String stockName, String startDate, String endDate, Integer pageNo) {
        return null;
    }

    @VolumeOrder(orderType = Order.DESC)
    private List<Stock> printStockVolumeInfo(String stockName, String startDate, String endDate) {
        return null;
    }
}
