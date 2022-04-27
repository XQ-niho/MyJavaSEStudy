package com.syed.day18_io;

import java.io.File;
import java.io.IOException;

/**
 * @program: MyJavaSE
 * @description: Java.io.File类
 * 该类用来映射/創建本地或者远程的文件/文件夹
 * @author: USER
 * @create: 2022-04-06
 */
public class FileDemo {
    public static void main(String[] args) {
        //創建File实例
        File file = new File("com\\syed\\homework\\homework0329\\w.dic");
        /**
         * 读取文件相关信息
         * 注意：读取的信息是文件的参数信息，非文件内部信息，要读取文件里面的内容，必须使用IO流
         */
        //获取文件名
        System.out.println(file.getName());
        //获取文件的绝对路径
        System.out.println(file.getAbsolutePath());
        //获取文件大小
        System.out.println(file.length());
        //获取最后一次修改时间
        System.out.println(file.lastModified());
        //判断文件是否可读，可写，隐藏
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
        //判断是否是文件还是文件夹
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        //判断文件或者文件夹是否存在
        System.out.println(file.exists());

        File file1 = new File("D:\\KindsCode\\MyJavaSE");
        FileDemo fileDemo = new FileDemo();
        fileDemo.findFile(file1);
    }

    /**
     * 創建文件
     */
    public void createFile(String path) {
        if (path != null) {
            File file = new File(path);
            try {
                boolean newFile = file.createNewFile();
                if (newFile) {
                    System.out.println(path + ",創建成功");
                } else {
                    System.out.println(path + ",文件已存在");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("目标路径不能为空");
        }
    }

    /**
     * 创建文件夹
     */
    public void createDirectory(String path) {
        if (path != null) {
            File file = new File(path);
            //mkdir只能创建一层路径，mkdirs可以创建可以创建多层路径
            boolean newDirectory = file.mkdirs();
            if (newDirectory) {
                System.out.println(path + "创建成功");
            } else {
                System.out.println(path + "文件夹已存在");
            }

        } else {
            System.out.println("目标路径已存在");
        }
    }

    /**
     * 删除文件
     * 注意：delete()只能删除文件或空的文件夹
     */
    public void deleteFile(String path) {
        if (path != null) {
            File file = new File(path);
            if (file.exists()) {
                boolean delete = file.delete();
                if (delete) {
                    System.out.println("删除成功");
                } else {
                    System.out.println("删除失败");
                }
            } else {
                System.out.println("目标文件不存在");
            }
        } else {
            System.out.println("目标路径不能为空");
        }
    }

    /**
     * 查看文件夹
     * 注意：listFile()或者list()方法默认只能获取但钱文件夹下的内容，无法获取深层目录信息
     */
    public void showFolder(String path) {
        if (path != null) {
            File file = new File(path);
            if (file.isDirectory()) {
                //把当前文件夹下所有的文件或者文件夹的File实例放入到数组中
                //File[] files = file.listFiles();

                //可以传入参数,来实现指定罗列符合规则的内容(过滤)
               /* File[] files = file.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        //添加过滤规则,必须是.exe文件
                        return new File(dir,name).getName().endsWith(".exe");
                    }
                });*/

                //添加过滤规则,必须是.exe文件
                File[] files = file.listFiles((dir, name) -> new File(dir, name).getName().endsWith(".dll"));
                if (files != null) {
                    for (File file1 : files) {
                        if (file1.isFile()) {
                            System.out.println("文件名：" + file1.getName() + "文件大小：" + file1.length());
                        } else {
                            System.out.println("文件夹名：" + file1.getName());
                        }
                    }
                } else {
                    System.out.println("文件为空");
                }
            } else {
                System.out.println("目标不是目录");
            }
        } else {
            System.out.println("目标路径不能为空");
        }
    }

    /**
     * 查看文件
     */
    public void findFile(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    System.out.println("这是文件夹" + f.getName());
                    findFile(f);
                } else {
                    System.out.println("这是文件" + f.getName());
                }
            }
        }
    }
}
