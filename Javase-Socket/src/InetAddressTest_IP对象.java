/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、网络编程中有两个主要的问题：
 *  1.如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 *  2.找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素：
 *  1.对应问题一：IP和端口号
 *  2.对应问题二：提供网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路层）
 *
 *
 * 三、通信要素一：IP和端口号
 *
 *  1. IP:唯一的标识 Internet 上的计算机（通信实体）
 *  2. 在Java中使用InetAddress类代表IP
 *  3. IP分类：IPv4 和 IPv6 ; 万维网 和 局域网
 *  4. 域名:   www.baidu.com   www.mi.com  www.sina.com  www.jd.com
 *            www.vip.com
 *           DNS(域名解析服务器)
 *      域名    ------->     IP地址
 *  5. 本地回路地址：127.0.0.1 对应着：localhost
 *
 *  6. 如何实例化InetAddress:两个方法：getByName(String host) 、 getLocalHost()
 *        两个常用方法：getHostName() / getHostAddress()
 *
 *  7. 端口号：标记正在计算机上运行的进程。
 *  要求：不同的进程有不同的端口号
 *  范围：被规定为一个 16 位的整数 0~65535。
 *
 *  8. 端口号与IP地址的组合得出一个网络套接字：Socket
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/27 13:18
 */
public class InetAddressTest_IP对象 {
    @Test
    public void test() {

        try {
            //InetAdress构造器私有化了，通过调用getByName返回IP地址的对象
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);

            //获取本地ip
            //方式一：
            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);
            //方式二：
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            //getHostName(): 获取该对象的域名
            System.out.println(inet2.getHostName());
            //getHostAddress(): 获取该对象的IP地址
            System.out.println(inet2.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}