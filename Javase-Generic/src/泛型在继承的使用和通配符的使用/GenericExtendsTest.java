package 泛型在继承的使用和通配符的使用;

import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. 泛型在继承方面的体现
 *  虽然类A是类B的父类，但是G<A> 和G<B>二者不具备子父类关系，二者是并列关系。
 *  如：List<Object> 和 List<String> （二者并非父子类关系，而是并列）
 *
 *  补充：类A是类B的父类或接口，A<G> 是 B<G> 的父类
 *  如：List<String> 和 ArrayList<String>  （父子类关系）
 *      AbstractList<String> 和 ArrayList<String>（接口关系）
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/23 19:32
 */
public class GenericExtendsTest {

    @Test
    public void test1() {

        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;
        //编译不通过（不是父子类之间的关系，无法赋值继承）
//        Date date = new Date();
//        str = date;

        List<Object> list1 = null;
        List<String> list2 = new ArrayList<String>();
        //编译不通过
        //此时的list1和list2的类型不具有子父类关系
//        list1 = list2;
        /*
        反证法：
        假设list1 = list2;
        list1也指向堆空间的list2定义的区域
        但是list1的类型为Object，可以添加任意元素。所以可以调用add（Object obj）
        list1.add(123);导致list2的堆空间混入非String的数据。出错。

         */
        show(list1);
        show1(list2);
    }

    public void show1(List<String> list) {

    }

    public void show(List<Object> list) {

    }

    @Test
    public void test2() {

        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        //A<G> 是 B<G> 的父类
        List<String> list4 = new ArrayList<>();

    }
}