package com.syed.util;

import java.io.*;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-06
 */
public class MyFileUtil {

    public static void main(String[] args) {
//        File file = new File("C:\\Users\\USER\\Desktop\\homework");
//        findAllFile(file);
//        deleteFileAndFolder(file);
        copyFolder("C:\\Users\\USER\\Desktop\\homework", "D:\\test");
    }

    /**
     * 删除任意文件或者文件夹
     */
    public static void deleteFileAndFolder(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    f.delete();
                } else {
                    deleteFileAndFolder(f);
                    f.delete();
                }
            }
        }
    }

    /**
     * 罗列指定文件夹下所有的文件和文件夹，包括深层结构中的
     */
    public static void findAllFile(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    System.out.println("这是文件夹->" + f.getName());
                    findAllFile(f);
                } else {
                    System.out.println("这是文件->" + f.getName() + "  文件大小->" + f.length());
                }
            }
        }
    }

    /**
     * 拷贝文件夹
     */
    public static void copyFolder(String src, String target) {
        File srcFile = new File(src);
        File tarFile = new File(target);
        File[] files = srcFile.listFiles();
        if (!tarFile.exists()) {
            tarFile.mkdirs();
        }
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    copyFile(f.getPath(), target + "\\" + f.getName());
                } else {
                    copyFolder(f.getPath(), target + "\\" + f.getName());
                }
            }
        }
   }
    public static void copyFile(String src, String target) {
        try (BufferedInputStream fin = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream fou = new BufferedOutputStream(new FileOutputStream(target))) {
            byte[] bytes = new byte[1024];
            while (fin.read(bytes) != -1) {
                fou.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 剪切文件或文件夹
     */
    public static void cutFileOrFolder(String src, String target) {
        File srcFile = new File(src);
        File tarFile = new File(target);
        File[] files = srcFile.listFiles();
        if (!tarFile.exists()) {
            tarFile.mkdirs();
        }
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    if(f.getPath().equals(target)){
                        copyFile(f.getPath(), target + "\\" + f.getName());
                    }
                } else {
                    copyFolder(f.getPath(), target + "\\" + f.getName());
                }
            }
        }
    }


}
