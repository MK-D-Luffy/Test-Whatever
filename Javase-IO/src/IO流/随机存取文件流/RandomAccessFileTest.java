package IO流.随机存取文件流;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 *  构造器:public RandomAccessFile(File file, String mode)
 *        public RandomAccessFile(String name, String mode)
 *
 *  创建RandomAccessFile 类实例需要指定一个mode参数，该参数指
 *  定RandomAccessFile 的访问模式：
 *      r: 以只读方式打开
 *      rw：打开以便读取和写入
 *      rwd:打开以便读取和写入；同步文件内容的更新
 *      rws :打开以便读取和写入；同步文件内容和元数据的更新
 *
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 * 如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 *
 * 4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/27 10:32
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            //1.
            raf1 = new RandomAccessFile(new File("爱情与友情.jpg"), "r");
            raf2 = new RandomAccessFile(new File("爱情与友情1.jpg"), "rw");
            //2.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void test2() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");

        raf1.seek(3);//将指针调到角标为3的位置
        raf1.write("xyz".getBytes());//

        raf1.close();

    }

    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {

        //1.创建文件 + 2.创建流
        RandomAccessFile w = new RandomAccessFile("hello.txt", "rw");


        //3.实现插入操作
        //将指针调到角标为3的位置
        w.seek(3);
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = w.read(buffer)) != -1) {
            builder.append(new String(buffer, 0, len));
        }

        //调回指针，写入“xyz”
        w.seek(3);
        w.write("xyz".getBytes());

        //将StringBuilder中的数据写入到文件中
        w.write(builder.toString().getBytes());


        //4.关闭流资源
        w.close();

        //思考：将StringBuilder替换为ByteArrayOutputStream
    }

}