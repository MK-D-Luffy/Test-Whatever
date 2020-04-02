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
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端，并关闭相应的连接。
 * <p>
 * 关闭数据的输出(!!!)：socket.shutdownOutput();
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/27 16:35
 */
public class TCPTest3 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        try {
            //1.创建socket指明服务器端的ip地址和端口
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 1234);

            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();

            //3.创建输入流，用于从客户端本地读取文件到内存中
            bis = new BufferedInputStream(new FileInputStream("dva.png"));

            //4.读入+写出操作（客户端）
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            //关闭数据的输出(!!!)
            socket.shutdownOutput();

            //5.接收来自于服务器端的数据，并显示到控制台上
            InputStream is = socket.getInputStream();
                //接受文字时用ByteArrayOutputStream避免出现乱码
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //6.关闭资源
                if (bis != null) {
                    bis.close();
                }
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
        BufferedOutputStream bos = null;
        try {
            //1.创建服务器端的ServerSocket，指明交互的端口号
            serverSocket = new ServerSocket(1234);

            //2.调用accept接受来自客户端的socket
            socket = serverSocket.accept();


            //3.创建输入流（处理从客户端输入服务器端的数据）
            is = socket.getInputStream();

            //4.创建服务器端内存到服务器端本地输出流（服务端）
            bos = new BufferedOutputStream(new FileOutputStream("dva1.png"));


            //5.读入+写出操作（服务器端）
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            //6.服务器端接受到文件给客户端反馈表明文件已收到
            OutputStream os = socket.getOutputStream();
            os.write("照片已经传送成功了！".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //7.关闭资源
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