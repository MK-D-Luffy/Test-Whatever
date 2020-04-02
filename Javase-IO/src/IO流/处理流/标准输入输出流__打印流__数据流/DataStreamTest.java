package IO流.处理流.标准输入输出流__打印流__数据流;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 3.数据流
 *  3.1 DataInputStream 和 DataOutputStream
 *  3.2 作用：用于读取或写出基本数据类型的变量或字符串
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/26 16:47
 */
public class DataStreamTest {

    /**
     * 数据流写出操作:
     *  练习：将内存中的字符串、基本数据类型的变量写出到文件中。
     *  注意：处理异常的话，仍然应该使用try-catch-finally.
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {

        //1.指定文件 + 2.指定流对象
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

        //2.写出操作（writeXxx）
        dos.writeUTF("刘建辰");
        dos.flush();//刷新操作，将内存中的数据写入文件
        dos.writeInt(23);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        //3.关闭流资源
        dos.close();

    }

    /**
     * 数据流读入操作:
     *  将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中。
     *  注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！
     * @throws IOException
     */
    @Test
    public void testDataStream() throws IOException {
        //1.指定文件 + 2.指定流对象
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

        //3.读入操作（readXxx）
        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("isMale = " + isMale);

        //4.关闭流资源
        dis.close();

    }
}