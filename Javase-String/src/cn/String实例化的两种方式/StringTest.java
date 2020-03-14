package cn.String实例化的两种方式;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

/**
 * String的使用
 * <p>
 * 1.String声明为final的，不可被继承。
 * 2.String实现Serializable接口：表示字符串是支持序列化的。
 *          实现了Comparable接口：表示字符串可以比较大小。
 * 3.String内部定义了final char[] value用于存储字符串数据。
 * 4.String：代表不可变的字符串序列。简称：不可变性。(!!!)
 *      体现：1.当对字符串重新赋值时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
 *          2.当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
 *          3.当调用String的replace（）方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
 *      总结：对于定义在字符串常量池中的String，只要String的值发生改变，地址就会随之改变。（不同于地址类的地址特性，依靠于字符串常量池。）
 * 5.通过字面量的方式（区别于new，直接赋值）给一个字符串赋值，此时的字符串值声明在字符串常量池中。（!!!）
 * 6.字符串常量池中是不会存储相同内容的字符串的。（!!!）
 *
 * @author 今天也要努力的小白
 * @date 2020/3/14 8:12
 */
public class StringTest {
    public static void main(String[] args) {
        //字面量的方式赋值
        String s1 = "abc";
        String s2 = s1;
        s2 = s2 + "abc";//有变量的拼接结果会在堆中，会new一个实例对象

        System.out.println(s1 == s2);//false
        System.out.println(s1);
        System.out.println(s2);

    }
}
