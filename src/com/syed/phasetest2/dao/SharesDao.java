package com.syed.phasetest2.dao;

import com.syed.phasetest2.entity.Shares;

import java.io.File;
import java.util.List;

/**
 * @program: MyJavaSEStudy
 * @description:
 * @author: USER
 * @create: 2022-04-26
 */
public interface SharesDao {
    /**
     * 获得所有文件
     */
    List<File> getAllFile();

    /**
     * 解析所有文件
     */
    List<Shares> parsingAllFile();
}
