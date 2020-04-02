package IO流.节点流;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 将Javase-IO下的hello.txt文件内容读入程序中，并输出到控制台。
 *
 * 说明点：
 * 1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
 * 2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
 * 3. 读入的文件一定要存在，否则就会报FileNotFoundException。
 *
 * read方法的升级：使用read的重载(!!!)
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/25 9:46
 */
public class FileReaderTest {

    @Test
    public void testReader() {
        FileReader reader = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");

            //2.提供具体的流
            reader = new FileReader(file);

            //3.数据的读入
            int data = reader.read();
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
            //方式一：
//        int data = fr.read();
//        while(data != -1){
//            System.out.print((char)data);
//            data = fr.read();
//        }

            //方式二：语法上针对于方式一的优化
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //read方法的升级：使用read的重载(!!!)
    @Test
    public void testRead() {
        FileReader fileReader = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");

            //2.FileReader流的实例化
            fileReader = new FileReader(file);

            //3.读入的操作
            //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            //read(char[] cbuf,offset,length)(XXX)：错误的，每从数组的offset中读length个。

            //cbuf指定为存放读入数据的容器
            char[] cbuf = new char[5];
            //len表示cbuf实际读入的个数（与length不同）
            int len;

            while ((len = fileReader.read(cbuf)) != -1) {
                //方式一：直接遍历char[]数组输出。
                //错误的写法
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);
//                }

                //正确的写法
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }

                //方式二:利用String的构造器，将char[]数组变为String输出。
//                错误的写法,对应着方式一的错误的写法
//                String str = new String(cbuf);
//                System.out.print(str);

                //正确的写法
                System.out.println(new String(cbuf, 0, len));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}