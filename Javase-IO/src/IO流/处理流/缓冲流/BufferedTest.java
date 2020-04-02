package IO流.处理流.缓冲流;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流：
 *  BufferedInputStream
 *  BufferedOutputStream
 *  BufferedReader
 *  BufferedWriter
 *
 * 2.作用：提供流的读取、写入的速度
 *  提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3. 处理流，就是“套接”在已有的流(!)的基础上。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/26 9:20
 */
public class BufferedTest {
    @Test
    public void testBufferedStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.指定要操作的文件
            File file1 = new File("C:\\Users\\Administrator\\Desktop\\01.avi");
            File file2 = new File("C:\\Users\\Administrator\\Desktop\\03.avi");


            //2.指定流
            //2.1指定节点流
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            //2.2指定缓冲流(处理流)
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);


            //3.读入和写出操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);

//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                //4.关闭流
                //要求：先关闭外层的流，再关闭内层的流
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//            fis.close();
//            fos.close();
        }
    }


    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制

     */
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //1.创建文件和 2.相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //3.读写操作
            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }

            //方式二：使用String(新增方法readLine())
            String data;
            while((data = br.readLine()) != null){
                //方法一：
//                bw.write(data + "\n");//data中不包含换行符

                //方法二：
                bw.write(data);//data中不包含换行符
                bw.newLine();//提供换行的操作(!!!)

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}