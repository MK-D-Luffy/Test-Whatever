package ClassLoader的理解; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import 反射概述.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类加载器的作用: 将.class(字节码)文件加载到内存(方法区)中，并在堆中创建一个Class类的对象，
 *                以访问方法区中的类数据(类结构)。不同的类对象需要使用不同的类加载器。
 *
 * 了解类的加载器: 分为两种类型：系统加载器和自定义类加载器；
 * 其中系统加载器包括三种：BootStrap ClassLoader、Extensions ClassLoader 和 Application ClassLoader
 *                          引导类加载器            扩展类加载器(JDK8)           应用程序加载器
 *                       (负责java平台核心库)  (负责加载jre/lib/ext下的jar包)  (用于自定义类的加载)
 *
 * Properties类读取配置文件的两种方式:
 *  1)直接创建输入流对象。
 *  2)通过调用类加载器的getResourceAsStream(file)方法获取输入流对象。
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/30 16:35
 */
public class ClassLoaderTest {

    @Test
    public void test1() {

        //getClassLoader(): 获取当前类(对象)的加载器
        //getParent(): 获取当前加载器的上一层加载器

        //对于自定义类，使用应用程序加载器进行加载
        ClassLoader classLoader = Person.class.getClassLoader();
        System.out.println(classLoader);

        //调用应用程序加载器的getParent()：获取平台类加载器（JDK8及以前为扩展类加载器）
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库（String），无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);

    }

    //Properties：用来读取配置文件。(!!!)
    //读取配置文件的两种方式:
    @Test
    public void test2() throws IOException {

        Properties properties = new Properties();

        //读取配置文件的方式一：
        //此时的配置文件默认在当前的module下。
//        FileInputStream fis = new FileInputStream(new File("jdbc.properties"));
//        properties.load(fis);

        //读取配置文件的方式二：
        //配置文件默认识别在当前module的src目录下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        properties.load(is);

        String name = properties.getProperty("name");
        String IGNScore = properties.getProperty("IGNScore");
        System.out.println("name = "+name+",IGNScore = " + IGNScore);

    }

}