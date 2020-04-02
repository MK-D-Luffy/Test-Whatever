/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * 1.URL:统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 *  http://localhost:8080/examples/beauty.jpg?username=Tom
 *  协议   主机名    端口号     资源地址          参数列表
 *
 * 常用方法：
 *  String getProtocol( )  获取该URL的协议名
 *  String getHost( )      获取该URL的主机名
 *  String getPort( )      获取该URL的端口号
 *  String getPath( )      获取该URL的文件路径
 *  String getFile( )      获取该URL的文件名
 *  String getQuery( )     获取该URL的查询名(参数列表)
 *
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/27 17:46
 */
public class URLTest {
    @Test
    public void testURL() {
        try {

            URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");

//            public String getProtocol(  )        获取该URL的协议名
            System.out.println(url.getProtocol());
//            public String getHost(  )           获取该URL的主机名
            System.out.println(url.getHost());
//            public String getPort(  )           获取该URL的端口号
            System.out.println(url.getPort());
//            public String getPath(  )           获取该URL的文件路径
            System.out.println(url.getPath());
//            public String getFile(  )           获取该URL的文件名
            System.out.println(url.getFile());
//            public String getQuery(   )        获取该URL的查询名(参数列表)
            System.out.println(url.getQuery());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}


