package IO流.处理流.标准输入输出流__打印流__数据流;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1.标准的输入、输出流
 * 1.1
 * System.in:标准的输入流，默认从键盘输入    (InputStream is)
 * System.out:标准的输出流，默认从控制台输出  (PrintStream ps)
 *
 * 1.2
 * System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的流。
 *
 * 1.3练习：
 * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
 * 直至当输入“e”或者“exit”时，退出程序。
 *
 * 方法一：使用Scanner实现，调用next()返回一个字符串
 * 方法二：使用System.in实现。System.in  --->  转换流 ---> BufferedReader的readLine()
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/26 15:04
 */
public class SystemIn$OutTest {

    //用IO的标准输入流操作

    @Test
    public void testSystemIn() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);

        //方式一：Read抽象基类读入操作: read(cbuf)
//        char[] cbuf = new char[5];
//        int len;
//        while ((len=isr.read(cbuf))!=-1){
//            System.out.print(new String(cbuf,0,len));
//        }
//
//        isr.close();

        //方式二：BufferedReader的readLine()
        BufferedReader br = new BufferedReader(isr);
        String s;
        while ((s=br.readLine())!=null){
            System.out.println(s);
        }

        br.close();
    }
}