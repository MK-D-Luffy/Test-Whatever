package 获取运行时类的所有结构.获取;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import 获取运行时类的所有结构.提供结构丰富的Person类.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 获取构造器结构和其他结构(如父类,泛型!,父类的泛型,接口,包,注解...)
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/31 9:52
 */
public class OtherTest {

    //获取构造器结构
    //获取构造器的具体结构...
    //...

    @Test
    public void test1() {

        Class<Person> clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> cons : constructors) {
            System.out.println(cons);
        }

        System.out.println();

        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器(不包含父类)
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> cons : declaredConstructors) {
            System.out.println(cons);
        }

    }

    //获取运行时类的父类

    @Test
    public void test2() {
        Class clazz = Person.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    //获取运行时类的带泛型的父类

    @Test
    public void test3() {
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }


    /**
     * 获取运行时类的带泛型的父类的泛型
     * <p>
     * 代码：逻辑性代码  vs 功能性代码
     */

    @Test
    public void test4() {
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        //有具体泛型(不是 K , V )
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();

        //两种方法都能获取泛型类型的名称(如 java.lang.String )
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class) actualTypeArguments[0]).getName());

    }


    //获取运行时类实现的接口

    @Test
    public void test5(){
        Class clazz = Person.class;

        //获取运行时类实现的接口
        Class[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }

        System.out.println();

        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.print(c);
        }

    }

    //获取运行时类所在的包

    @Test
    public void test6() {
        Class<Person> clazz = Person.class;

        Package clazzPackage = clazz.getPackage();
        System.out.println(clazzPackage);

    }

    //获取运行时类声明的注解

    @Test
    public void test7() {
        Class<Person> clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }

}