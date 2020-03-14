package cn.String实例化的两种方式;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

/**
 * String的实例化方式：
 * 方式一：通过字面量定义的方式
 * 方式二：通过new+构造器的方式
 * <p>
 * 面试题：String s =new String("abc");方式创建对象，在内存中创建了几个对象？(!!!)
 *      两个：一个是堆空间中new的实例对象(存放的是常量池中对象的地址)，另一个是char[]对应的常量池中的对象："abc"。
 *
 * @author 今天也要努力的小白
 * @date 2020/3/14 9:12
 */
public class StingTest1 {
    public static void main(String[] args) {
        //通过字面量定义的方式：此时的s1和s2数据javaEE声明在方法区中的字符串常量池中。而该(局部)变量是声明在栈中，保存的是javaEE地址。
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new+构造器的方式：此时的s3和s4保存的是堆中创建的地址值，堆中保存的是该值在常量池中的地址。因为new会创建一个实例对象保存在堆中。
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);//true(s1，s2的数据值相等是定义在字符串常量池中的同一个数)
        System.out.println(s1 == s3);//false（s1存放的直接是常量池中的地址，而s3和s4存放的是堆中实例对象的地址，
        System.out.println(s1 == s4);//false  而该由该对象存放字符串常量池中的数据地址。）
        System.out.println(s3 == s4);//false (s3,s4作为两个实例对象，地址是自然不同的。)
    }
}
