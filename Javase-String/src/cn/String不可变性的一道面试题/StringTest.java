package cn.String不可变性的一道面试题;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

/**
 * 一道面试题（String的不可变性）
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/14 10:48
 */
public class StringTest {

    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};


    //形参是str堆对象的地址，由于字符串的不可变性，给该形参赋值实际上是在字符串常量池中创建了一个新的对象，然而该堆对象本身没有改变
    public void change(String str, char ch[]) {
        //字符串的不可变性(给字符串赋值会重新创建一个量在字符串常量池中)
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
    }
}