package 泛型在继承的使用和通配符的使用;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1. 通配符的使用。
 *      通配符：?
 *      类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
 *
 * 2.有限制条件的通配符的使用。
 *         ? extends A:（? <= A）
 *                 G<? extends A> ?的类型可以是A的子类也可以是A本身。
 *         ? super A:（? >= A）
 *                 G<? super A>  ?的类型可以是A的父类也可以是A本身。
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/23 19:53
 */
public class WildcardTest {
    //1.通配符的使用
    @Test
    public void test1() {
        //List<?>是作为List<Object>和 List<String>的父类存在的
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;

        //调用print(List<?> list)：编译通过
        print(list1);
        print(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加(写入)：对于List<?>就不能向其内部添加数据。
        //除了添加null之外。
//        list.add("DD");
//        list.add('?');

        list.add(null);

        //获取(读取)：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);

    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    //2.有限制条件的通配符的使用。
    @Test
    public void test2() {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        //? extends Person 可以放入A的子类或是A本身。
        list1 = list3;
        list1 = list4;
//        list1 = list5;

        //? super Person 可以放入A的父类或是A本身。
//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //1)读取数据：
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
        //Student s = list1.get(0);

        list2 = list4;
        Object obj = list2.get(0);
        ////编译不通过
//        Person obj = list2.get(0);


        //2)写入数据：
        //编译不通过,? extends Person不能add元素.
//        list1.add(new Student());

        //编译通过
        //? >= Person ，所以向上类型转换，可以放入Person类或其子类Student
        list2.add(new Person());
        list2.add(new Student());

    }
}