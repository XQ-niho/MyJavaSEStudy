package com.syed.phasetest2.dao.impl;

import com.syed.phasetest2.config.IConstants;
import com.syed.phasetest2.dao.SharesDao;
import com.syed.phasetest2.entity.Shares;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

/**
 * @program: MyJavaSEStudy
 * @description:
 * @author: USER
 * @create: 2022-04-26
 */
public class SharesDaoImpl implements SharesDao, IConstants {
    @Override
    public List<File> getAllFile() {
        List<File> allFile = null;
        File directory = new File(PATH_OF_SOCKET_DATA);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                allFile = new ArrayList<>(Arrays.asList(files));
            }
        }
        return allFile;
    }

    @Override
    public List<Shares> parsingAllFile() {
        List<Shares> Shares = new ArrayList<>();
        Shares share = null;
        List<File> allFile = getAllFile();
        for (File file : allFile) {
            String[] filePathSpl = file.getPath().split("[.]");
            String fileSuffix = filePathSpl[filePathSpl.length - 1];
            if ("dat".equals(fileSuffix)) {
                try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream(file.getPath()))) {
                    ArrayList arrayList = (ArrayList) fin.readObject();
                    for (Object e : arrayList) {
                        Set fieldNameSet = ((LinkedHashMap) e).keySet();
                        for (Object object : fieldNameSet) {
                            ((LinkedHashMap)e).get(object);
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if ("csv".equals(fileSuffix)) {

            }
        }
        return null;
    }
}
