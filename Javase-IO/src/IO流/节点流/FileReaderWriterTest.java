package IO流.节点流;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 *
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/25 13:47
 */
public class FileReaderWriterTest {

    @Test
    public void test() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            //1.指明要操作的文件
            File srcfile = new File("hello.txt");
            File destfile = new File("hello2.txt");

            //2.指明流对象
            fileReader = new FileReader(srcfile);
            fileWriter = new FileWriter(destfile, true);

            //3.读入和写出操作
            char[] cbuf = new char[5];
            int len;
            while ((len = fileReader.read(cbuf)) != -1) {
                fileWriter.write(new String(cbuf, 0, len));
                //fileWriter.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //方式二：
//            try {
//                if(fileWriter != null)
//                    fileWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if(fileReader != null)
//                    fileReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}