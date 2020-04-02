package 泛型的使用; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 * 1. 泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：<E1,E2,E3>
 * 2. 泛型类的构造器如下：public 泛型的使用.GenericClass(){}。
 *    而下面是错误的：public 泛型的使用.GenericClass<E>(){}
 * 3. 实例化后，原来类中使用泛型T的位置的结构必须与指定的泛型类型一致。
 *
 * 4. 泛型不同的引用不能相互赋值。
 *      >尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，但是
 *      在运行时只有一个ArrayList被加载到JVM 中。
 * 5. 泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价于Object。
 *    经验：泛型要使用一路都用。要不用，一路都不要用。
 * 6. 如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象。
 * 7. jdk1.7，泛型的简化操作：ArrayList<Fruit> fruit = new ArrayList<>();
 *
 * 8. 泛型的指定中不能使用基本数据类型，可以使用包装类替换。
 * 9. 在静态方法中不能使用类的泛型。(创建一个实例对象时，先加载静态区，在加载构造方法，此时才指定的泛型。)
 * 10. 异常类不能是泛型的。(即继承与Exception或RunTimeException的类)
 *
 * 11. 不能使用new E[]。但是可以：E[] elements = (E[])new Object[capacity];
 *     参考：ArrayList源码中声明：Object[] elementData，而非泛型参数类型数组。
 * 12. 父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型：
 *   子类不保留父类的泛型：按需实现
 *       没有类型 擦除
 *       具体类型
 *   子类保留父类的泛型：泛型子类
 *       全部保留
 *       部分保留
 *  结论：子类必须是“富二代”，子类除了指定或保留父类的泛型，还可以增加自己的泛型
 *
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/23 15:17
 */
public class CustomGenericTest {
    //自定义泛型类测试
    @Test
    public void test1() {
        //如果自定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家使用的类是带泛型的，建议在实例化时要指明类的泛型。
        GenericClass<Integer> genericClass = new GenericClass<>("Matt" ,123);
        Integer t = genericClass.getT();
        System.out.println(t);

    }

    //定义泛型方法
    //泛型方法：在方法中出现了泛型的结构，泛型参数与类指定的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类都没有关系。
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
    public static <E> List<E> ArrayFormatList(E[] arr){
        List<E> list = Arrays.asList(arr);
        return list;
    }

    //测试泛型方法
    @Test
    public void test2() {
        Integer[] arr = {1, 2, 3, 4, 5};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> integers = ArrayFormatList(arr);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}