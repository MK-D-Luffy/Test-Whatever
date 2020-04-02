package IO流.处理流.对象流_序列化;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是
 * 可以把Java中的对象写入到数据源中(持久保存)，也能把对象从数据源中还原回来。
 * 3.方法：readObject()和writeObject()
 *
 * 传输对象流的序列化机制(!!!)
 * 1.要想一个java对象是可序列化的，需要满足相应的要求。见Person.java
 *  Person需要满足如下的要求，方可序列化
 *  1)需要实现接口：Serializable
 *  2)当前类提供一个全局常量：serialVersionUID
 *  3)除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性
 *   也必须是可序列化的。（默认情况下，基本数据类型可序列化）
 *
 * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 * 2.序列化机制：
 *  对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而把这种
 *  二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。
 *  当其它程序获取了这种二进制流，就可以将其恢复成原来的Java对象。
 *
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/27 9:28
 */
public class ObjectStreamTest {
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            //1.创文件 + 2.创流
            oos = new ObjectOutputStream(new FileOutputStream(new File("object.dat")));

            //3.写入操作
            oos.writeObject(new String("我爱中国！"));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.关闭资源
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            //1. + 2.
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            //3.
            Object object = ois.readObject();
            String s = (String) object;
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}