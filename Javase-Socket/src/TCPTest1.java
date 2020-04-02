/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 * 操作说明：
 *  要想做到传输数据，就需要知道服务端的ip地址和端口号，而ip地址和端口号封装在了Socket中，
 *  所以要获取ip和端口号，需要创建socket对象获取其中的ip地址和端口号。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/27 14:44
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;

        try {
            //1.创建socket指明服务器端的ip地址和端口
            socket = new Socket(InetAddress.getByName("localhost"), 8888);

            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();

            //3.写出数据的操作
            os.write("我爱中国，我爱编程".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.关闭资源
                if (os != null) {
                    os.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //服务端
    @Test
    public void service() {
        //1创建服务器端的ServerSocket，指明自己的端口号
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        try {
            ss = new ServerSocket(8888);

            //2.调用accept（）表示接受来自于客户端的socket
            socket = ss.accept();

            //3.获取输入流对象
            is = socket.getInputStream();

            //4.读取输入流中的数据
            //不推荐使用，可能会出现乱码
//            byte[] buffer = new byte[1024];
//            int len;
//            while ((len = is.read(buffer)) != -1) {
//                System.out.print(new String(buffer, 0, len));
//            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len=is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //5.关闭资源
                if (is != null) {
                    is.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (ss != null) {
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}