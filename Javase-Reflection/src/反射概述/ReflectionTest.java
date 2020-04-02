package 反射概述; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射机制的概述:
 *  1.Reflection（反射）是被视为动态语言的关键，反射机制允许程序在执行期
 *  借助于Reflection API取得任何类的内部信息，并能直接操作任意对象的内
 *  部属性及方法。
 *  2.加载完类之后，在堆内存的方法区中就产生了一个Class类型的对象（一个
 *  类只有一个Class对象），这个对象就包含了完整的类的结构信息。我们可
 *  以通过这个对象看到类的结构。
 *
 *
 * 疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个？
 *  建议：直接new的方式。
 *  什么时候会使用反射的方式。
 *  比如: 客户端和服务器端通信时，服务器端启动后(已处于运行时)，
 *        由客户端发送某个请求，服务器端创建相应的对象，进行操作
 *        体现了反射的特征：动态性
 *
 * 疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
 *  不矛盾。
 *  封装性解决的是怎么调的问题，建议调用普通权限的结构(如: public)，不建议调用私有权限的结构(如: private)。
 *  反射解决的是能不能调的问题(通过反射实际上可以获得类的所有结构)
 *
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/30 9:37
 */
public class ReflectionTest {

    //反射之前，对于Person的操作(只能调用对外暴露的结构)
    @Test
    public void test1() {

        //1.创建Person类的对象
        Person p1 = new Person("Tom", 12);

        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        //比如：name、showNation()以及私有的构造器
    }


    //反射之后，对于Person的操作（可以调用所有类的所有结构）
    @Test
    public void test2() throws Exception{

        Class clazz = Person.class;

        //1.通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());

        //2.通过反射，调用对象指定的普通属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("*******************************");

        //3.通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeimei");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        //相当于String nation = p1.showNation("中国")
        String nation = (String) showNation.invoke(p1,"中国");
        System.out.println(nation);

    }
}