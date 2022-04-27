package com.syed.phasetest2.dao.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: MyJavaSEStudy
 * @description:
 * @author: USER
 * @create: 2022-04-26
 */
public class SharesDaoImplTest {

    @Test
    public void getAllFile() {
        SharesDaoImpl sharesDao = new SharesDaoImpl();
        sharesDao.getAllFile();
    }

    @Test
    public void parsingAllFile() {
        SharesDaoImpl sharesDao = new SharesDaoImpl();
        sharesDao.parsingAllFile();
    }
}