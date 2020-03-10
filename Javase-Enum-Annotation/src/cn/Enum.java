package cn;

import java.util.Arrays;

/**
 * 2.使用enum关键字创建枚举类
 *
 * @author 今天也要努力的小白
 * @date 2020/3/8 10:05
 */
public class Enum {
    public static void main(String[] args) {
        Person1 xiaoli = Person1.Pxiaoli;
        System.out.println(xiaoli);
        System.out.println("---------------------");

        //value()方法,作用与类，将枚举类中的对象都罗列出来;
        Person1[] values = Person1.values();
        System.out.println(Arrays.toString(values));
        System.out.println("---------------------");

        //valueof(string str)方法，返回对象名为str的对象
        Person1 xiaoli1 = Person1.valueOf("Pxiaoli");
        System.out.println(xiaoli1);
    }
}

//enum关键字创建枚举类
enum Person1 {
    /**
     *enum关键字定义要先在开头定义对象名，有属性可以定义，没有不用定义
     * 对象之间用,号分隔，用;号结尾
     */
    Pxiaozhang("xiaozhang", "男", "18"),
    Pxiaozhao("xiaozhao", "男", "125"),
    Pxiaoli("xiaoli", "男", "52");

    //定义枚举对象的属性
    private final String name;
    private final String gender;
    private final String age;

    Person1(String name, String gender, String age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}