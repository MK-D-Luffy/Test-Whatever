package IO流.处理流.标准输入输出流__打印流__数据流;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 2.打印流：PrintStream 和PrintWriter
 *
 * 创建打印流可以将指定的默认的控制台输出，改为指定位置的文件输出:
 *  通过调用标准输出流的setOut方法（System.setOut(PrintStream out)）
 *  重定向后:  System.out.println(XXX)  将会默认再指定的文件中输出
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/26 16:58
 */
public class PrintStreamTest {

    @Test
    public void testPrintStream() {
        PrintStream ps = null;
        try {
            //1.指定文件 +2 创建流 （2.1 创建节点流）
            FileOutputStream fos = new FileOutputStream(new File("hello5.txt"));

            //2.2 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {
                // 把标准输出流(控制台输出)改成文件 (!!!)
                System.setOut(ps);
            }

            //3.写出操作（write(XXX) 或 System.out.print(XXX)...）
            // 输出ASCII字符
            for (int i = 0; i <= 255; i++) {
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            if (ps != null) {
                ps.close();
            }
        }
    }
}