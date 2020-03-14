package cn.String不同拼接操作的对比_内存层面;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

/**
 * String类型不同拼接操作对比：
 * 结论：
   1.字面量（常量）与字面量（常量）的拼接结果在常量池。且常量池中不会存在相同内容的常量。
   2.只要其中有一个是变量，结果就在堆中。（会在堆中new一个对象）
   3.如果拼接的结果调用intern()方法，返回值就会在常量池中
 *
 //补充：如果一个字符串加上了final，也就会变成常量
 Strings1="javaEEhadoop";

 final String s2="javaEE";
 String s3=s2+ "hadoop";
 System.out.println(s1==s3);//true
 *
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/14 10:15
 */
public class StringConcat {
    public static void main(String[] args) {
        String s1 = "javaEE";
        String s2 = "hadoop";


        /**
         *只有字面量的操作，字面量的拼接等的结果还是在字符串常量池中
         */
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        /**
         *只要有变量参与的结果就会在堆中，就会new一个实例对象
         * 如果想要拼接结果在直接在常量池中，则可以调用intern（）方法。
         */
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s5 == s6);//false


        //调用intern（）方法使原返回值会在常量池中声明
        String s7 = (s1 + "hadoop").intern();
        String s8 = ("javaEE" + s2).intern();
        String s9 = (s1 + s2).intern();
        //调用intern（）方法后
        System.out.println(s3 == s7);//true
        System.out.println(s3 == s8);//true
        System.out.println(s3 == s9);//true

    }
}
