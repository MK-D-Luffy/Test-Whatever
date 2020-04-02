package IO流.节点流;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 从内存中写出数据到硬盘的文件hello1.txt里。(write)
 *
 * 说明：
 * FileWriter构造器: FileWriter(File file ,boolean append)
 *  1.File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
 *  2.File对应的硬盘中的文件如果存在：
 *      默认 append = false,表示不追加，再次写出到该文件时会直接对原有的内容进行覆盖
 *      当 append = true 时，表示追加， 再次写入都文件时会追加，即在原有文件内容的基础上追加内容。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/25 13:46
 */
public class FileWriterTest {

    @Test
    public void testWriter() {
        //1.提供File类的对象，指明写出到的文件
        FileWriter fileWriter = null;
        try {
            File file = new File("hello1.txt");

            //2.提供FileWriter的对象，用于数据的写出
            fileWriter = new FileWriter(file);

            //3.写出的操作
            fileWriter.write("helloworld123");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    //4.流资源的关闭
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}