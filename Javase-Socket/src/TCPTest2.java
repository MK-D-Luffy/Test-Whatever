/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/27 16:06
 */
public class TCPTest2 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;

        try {
            //1.创建socket对象，以获得ip地址和端口号
            InetAddress localhost = InetAddress.getByName("localhost");
            socket = new Socket(localhost, 8888);

            //2.创建输出流
            os = socket.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("hello.txt"));

            //3.写出操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //服务端
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos =null;
        try {
            //1.创建ServerSocket对象
            serverSocket = new ServerSocket(8888);

            //2.调用accept表示来自于客户端的socket
            socket = serverSocket.accept();

            //3.创建输入流
            is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream("hello1.txt"));

            //4.写入操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //5.关闭资源
                if (bos != null) {
                    bos.close();
                }
                if (is != null) {
                    is.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}