package com.syed.day22_json_xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description 把XML转换成Java对象
 * 把Java对象转换成XML文件
 * @createTime 2022/4/11 15:01
 */
public class XMLParser {
    public static void main(String[] args) {
        /*List<Student> students = readFromXmlFile("src/com/syedu/day19/students.xml");
        students.forEach(System.out::println);*/

        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1L, "AA", LocalDate.now(), Gender.MALE, null);
        Student student2 = new Student(2L, "BB", LocalDate.now(), Gender.FEMALE, new Address("A", "B", "C"));
        Student student3 = new Student(3L, "CC", LocalDate.now(), Gender.MALE, new Address("A", "B", "C"));
        students.add(student1);
        students.add(student2);
        students.add(student3);
        writeIntoXml(students, "src/com/syed/day22/new_students.xml");
    }

    /**
     * XML的解析相比JSON的转换麻烦很多,解析方法如下:
     * 1.JDK内置方法 SAX解析 -- XML解析的简单API    淘汰
     * 2.JDK内置方法 DOM解析 -- 文档对象模型        淘汰
     * ...
     *
     * 由于JDK内置的解析方法都非常繁琐,所以第三方框架提供了相对来说好用的API来解析: dom4j
     * 注意:需要导入第三方Jar包 -- dom4j
     */
    //使用Dom4j解析XML文档
    public static List<Student> readFromXmlFile(String xmlPath) {
        List<Student> students = new ArrayList<>();
        try {
            //创建DOM4j解析器
            SAXReader reader = new SAXReader();
            //读取XML文档,在内存中生成一个Document对象 -- 内存中一颗倒置的文档树
            Document document = reader.read(xmlPath);
            //获取文档树根元素 -- students元素
            Element rootElement = document.getRootElement();
            //获取根元素下面所有的直接分支 -- 每个分支就是一个student元素
            List<Element> studentElements = rootElement.elements("student");
            Student student = null;
            //遍历元素集合,得到没一个student元素
            for (Element studentElement : studentElements) {
                //注意:以下所有获取值得方法返回都是String类型,所以需要进行对应的数据类型的转换
                //从studentElement上获取属性值
                Long id = Long.parseLong(studentElement.attributeValue("id"));//String->Long
                String name = studentElement.elementText("name");
                LocalDate birthday = LocalDate.parse(studentElement.elementText("birthday"),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd"));//String->LocalDate
                Gender gender = Gender.valueOf("男".equals(studentElement.elementText("gender")) ? "MALE" : "FEMALE");//String->Enum
                //每个学生元素都对应一个学生对象,把学生元素转换成学生对象
                student = new Student(id, name, birthday, gender, null);
                //获取地址信息
                Element addressElement = studentElement.element("address");
                Address address = null;
                //判断学生是否有地址
                if (addressElement != null) {
                    String province = addressElement.elementText("province");
                    String city = addressElement.elementText("city");
                    String area = addressElement.elementText("area");
                    address = new Address(province, city, area);
                    //把地址设置到学生对象上
                    student.setAddress(address);
                }
                //把转换好的学生对象添加到学生集合中
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    /**
     * 把Java对象写入到目标文件中,生成XML
     */
    public static void writeIntoXml(List<Student> students, String xmlPath) {
        //创建文档树对象
        Document document = DocumentHelper.createDocument();
        //添加根元素
        Element root = document.addElement("students");
        Element studentElement = null;
        Address address = null;
        //遍历学生集合
        for (Student student : students) {
            //得到每个学生Java对象,都对应一个学生元素
            studentElement = root.addElement("student");
            studentElement.addAttribute("id", student.getId() + "");
            studentElement.addElement("name").addText(student.getName());
            studentElement.addElement("birthday").addText(student.getBirthday().toString());
            studentElement.addElement("gender").addText(student.getGender().toString());
            //处理地址信息
            address = student.getAddress();
            if (address != null) {
                Element addressElement = studentElement.addElement("address");
                addressElement.addElement("province").addText(address.getProvince());
                addressElement.addElement("city").addText(address.getCity());
                addressElement.addElement("area").addText(address.getArea());
            }
        }
        XMLWriter writer = null;
        //创建输出流对象
        try (FileWriter fileWriter = new FileWriter(xmlPath)) {
            //注意: Dom4j中的XMLWriter输出流不支持自动关闭
            //第二个参数传入格式对象,来进行输出格式化
            OutputFormat outputFormat = new OutputFormat();
            //设置格式
            outputFormat.setEncoding("UTF-8");//编码
            outputFormat.setNewlines(true);//换行
            outputFormat.setIndentSize(5);//缩进
            writer = new XMLWriter(fileWriter, outputFormat);
            //把文旦树对象写到目标文件中
            writer.write(document);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //手动关闭
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
