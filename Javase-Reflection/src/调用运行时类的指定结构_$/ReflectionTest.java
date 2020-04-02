package 调用运行时类的指定结构_$;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import 获取运行时类的所有结构.提供结构丰富的Person类.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/31 10:42
 */
public class ReflectionTest {

    //1.1不需要掌握(不具有通用性，只能访问public修饰的)

    @Test
    public void testField() throws Exception {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person person = clazz.newInstance();

        //获取指定的属性（只能获取本类和父类中声明public的属性）
        //通常不采用此方法(不能获取权限较低的属性)
        Field id = clazz.getField("id");


        //设置当前属性的值
        //set(Object obj,Object value): obj：指明设置哪个对象的属性   value：将此属性值设置为多少
        id.set(person, 1001);

//        获取当前属性的值
//        get():参数1：获取哪个对象的当前属性值
        int pId = (int) id.get(person);
        System.out.println(pId);

    }


    //1.2如何操作运行时类中的指定的属性 -- 需要掌握(!!!)
    //使用 getDeclaredField(String fieldName)可以获取当前运行时类中任一的属性

    @Test
    public void testDeclaredField() throws Exception {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person person = clazz.newInstance();

        // 1.获取指定的某个属性
        // getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");


        //2.保证当前属性是可访问的
        name.setAccessible(true);


        //3.设置并获取指定对象的此属性值  set(Object obj,Object value)  get(Object obj)
        name.set(person, "haihai");
        System.out.println(name.get(person));

        //补充: 如果基础字段是静态字段，则忽略obj参数; 为null。
        // set(null , Object value)   get(null)
        Field hobby = clazz.getDeclaredField("hobby");
        hobby.set(null,"heihei");
        System.out.println(hobby.get(null));

    }


    //2.如何操作运行时类中的指定的方法 -- 需要掌握(!!!)

    @Test
    public void testMethod()  throws Exception{
        Class clazz = Person.class;

        Person person = (Person) clazz.newInstance();

        //1.获取指定的某个方法
        //getDeclaredMethod( name , ...param ):参数1 ：指明获取的方法的名称  参数2：指明获取的方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);


        //2.保证当前方法是可访问的
        show.setAccessible(true);


        //3. 调用方法的invoke( obj , ...param ):参数1：方法的调用者  参数2：给方法形参赋值的实参
        // invoke()的返回值即为对应类中调用的方法的返回值，如果没有返回值则返回null。

        Object chn = show.invoke(person, "CHN");
        System.out.println(chn);


        //补充: 访问静态方法
        // private static void showDesc()

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);

        //如果基础方法是静态方法，则忽略obj参数; 默认为null。
        Object returnVal = showDesc.invoke(Person.class);
//        Object returnVal = showDesc.invoke(null);

    }

    //3.如何调用运行时类中的指定的构造器

    @Test
    public void testConstructor() throws Exception {
        Class clazz = Person.class;
        //private Person(String name)

        //1.获取指定的构造器
        //getDeclaredConstructor(...param):参数：指明构造器的参数列表。
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        constructor.setAccessible(true);

        //3.调用此构造器对象的newInstance创建运行时类的对象(少)
        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per);

    }

}