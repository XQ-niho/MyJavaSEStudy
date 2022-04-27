package com.syed.day18_io;

import java.io.*;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-06
 */
public class FileCopyByBytes {
    public static void main(String[] args) {
        String src = "C:\\Users\\USER\\Desktop\\20220221java\\Java.xmind";
        String tar = "C:\\Users\\USER\\Desktop\\Java.xmind";
        new FileCopyByBytes().copyFileByBytes(src, tar);
    }


    /**
     * 效率不高
     */
    public void copyFileByBytes(String origin, String target) {
        try (InputStream fin = new FileInputStream(origin);
             OutputStream fou = new FileOutputStream(target, true)) {
            int len;
            while ((len = fin.read()) != -1) {
                fou.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用带缓存IO流来提高效率
     */
    public void copyFileByBytes1(String origin, String target) {
        try (InputStream fin = new FileInputStream(origin);
             OutputStream fou = new FileOutputStream(target)) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = fin.read(buf)) != -1) {
                fou.write(buf, 0, len);
                //fou.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 标准版带缓存IO流来提高效率
     * BufferedInputStream fin = new BufferedInputStream(new FileInputStream(origin))
     * BufferedOutputStream fou = new BufferedOutputStream(new FileOutputStream(target))
     */
    public void copyFileByBytes2(String origin, String target) {
        try (BufferedInputStream fin = new BufferedInputStream(new FileInputStream(origin));
             BufferedOutputStream fou = new BufferedOutputStream(new FileOutputStream(target))) {
            byte[] buf = new byte[1024];
            while (fin.read(buf) != -1) {
                fou.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
