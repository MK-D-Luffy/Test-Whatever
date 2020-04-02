package 获取Class实例的4种方式_$; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import 反射概述.Person;
import 反射概述.ReflectionTest;

/**
 * 获取Class的实例(类对象)的方式(前三种方式需要掌握):
 *  方式一：调用运行时类的属性: .class
 *  方式二：通过运行时类的对象,调用getClass()方法。
 *  方式三：调用Class的静态方法：forName(String classPath)（!!!）
 *  方式四：使用类的加载器：ClassLoader  (了解)
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/30 21:45
 */
public class ReflectGetInstance {

    //获取Class的实例的方式（前三种方式需要掌握）

    @Test
    public void test1() throws ClassNotFoundException {

        //Class<T>

        //方式一：调用运行时类的属性: .class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象,调用getClass()方法
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //classPath(全类名): 某个文件在项目或模块下的位置，包含包名在内的类名(格式: package.类名 )
        //方式三：调用Class的静态方法：forName(String classPath) (!!!)
        Class clazz3 = Class.forName("反射概述.Person");
//        clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);

        //类只加载了一次
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("反射概述.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz4);

    }
}
