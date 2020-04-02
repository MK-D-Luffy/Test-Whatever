package Class类的理解和类的加载_$; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;

/**
 * 关于java.lang.Class类的理解:
 * 1.类的加载过程：
 * 编译: 程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。(一个java类就对应着一个字节码文件)
 *
 * 解释运行:类的加载: 接着我们使用java.exe命令对某个字节码文件进行解释运行。(java Person.class)
 * 相当于将某个字节码文件加载到内存中。此过程就称为类的加载。(!!!)
 *
 * 加载到内存(方法区)中的类，我们就称为运行时类，在这里Person就是运行时类。
 * 此运行时类(Person类本身)，就可以作为Class类的一个实例。(!!!)
 * 用 Person.class 表示Person类本身，避免与作为类型的Person冲突)
 *
 * 2.换句话说，Class的实例就对应着一个运行时类(扩展...)。
 * 3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内(指在其生命周期时间内)，
 * 我们可以通过不同的方式来获取此运行时类。(运行时类只会被加载一次，所以类对象只存在一个)
 *
 *
 *  当程序主动使用某个类时，如果该类还未被加载到内存中，则系统会通过
 *  如下三个步骤来对该类进行初始化。
 *  1)加载(通过类加载器将.class(字节码)文件加载到内存)
 *  2)链接（为所有类属性分配内存并设置为默认初始值）
 *  3)初始化(按照先后顺序运行静态代码块和类属性的赋值操作)
 *  类对象只会初始化一次(或是说类只会加载一次)，第一次加载后
 *  后续的获取均为获取该类对象
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/30 12:43
 */
public class ClassTest {

    //万事万物皆对象？对象.xxx,File,URL,反射,前端、数据库操作

    /**
     * Class实例可以是哪些结构的说明：
     * （1）class：外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
     * （2）interface：接口
     * （3）[]：数组
     * （4）enum：枚举
     * （5）annotation：注解@interface
     * （6）primitive type：基本数据类型
     * （7）void
     */

    @Test
    public void test2() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);

    }
}