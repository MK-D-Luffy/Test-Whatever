package IO流.处理流.转换流;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 *
 * 1.转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3. 解码：字节、字节数组  --->字符数组、字符串
 * 编码：字符数组、字符串 ---> 字节、字节数组
 *
 *
 * 4.字符集
 *  ASCII：美国标准信息交换码。用一个字节的7位可以表示。
 *  ISO8859-1：拉丁码表。欧洲码表用一个字节的8位表示。
 *  GB2312：中国的中文编码表。最多两个字节编码所有字符
 *  GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 *  Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 *  UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。(最新是最多6个字节表示)
 *
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/26 13:55
 */
public class InputStreamReaderTest {

    // 此时处理异常的话，仍然应该使用try-catch-finally
    // InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
    @Test
    public void test1() throws IOException {

        FileInputStream fis = new FileInputStream("hello.txt");

//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        //参数 charsetName 指明了字符集，具体使用哪个字符集，取决于文件 hello.txt 保存时使用的字符集
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");//使用系统默认的字符集

        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            String str = new String(cbuf, 0, len);
            System.out.print(str);
        }

        isr.close();

    }

    //综合使用InputStreamReader和OutputStreamWriter
    //转换流实现读入和写出操作
    @Test
    public void test() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //1.造文件 + 2.造流（2.1造节点流 + 2.2造处理流（转换流））
            isr = new InputStreamReader(new FileInputStream("hello.txt"), "UTF-8");
            osw = new OutputStreamWriter(new FileOutputStream("hello5.txt"), "gbk");

            //3.实现读入和写出操作
            char[] cbuf = new char[5];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf, 0, len);
                System.out.print(new String(cbuf, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.关闭流资源
            try {
                if (osw != null) {
                    osw.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}