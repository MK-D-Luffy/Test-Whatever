package List集合.List常用方法; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * List接口中的常用方法：
 *  void add(int index, Object ele):在index位置插入ele元素
 *  boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
 *  Object get(int index):获取指定index位置的元素
 *  int indexOf(Object obj):返回obj在集合中首次出现的位置
 *  int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 *  Object remove(int index):移除指定index位置的元素，并返回此元素
 *  Object set(int index, Object ele):设置指定index位置的元素为ele
 *  List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
 *
 * 总结：常用方法:
 *  增：add(Object obj)
 *  删：remove(int index) / remove(Object obj)
 *  查：get(int index)
 *  改：set(int index, Object ele)
 *  插：add(int index, Object ele)
 *  长度：size()
 *  遍历：① Iterator迭代器方式
 *       ② 增强for循环
 *       ③ 普通的循环
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/20 11:40
 */
public class ListMethodTest {
    @Test
    public void test1() {
        //增/插：void add(int index, Object ele):在index位置插入ele元素
        ArrayList list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i, i);
        }
        System.out.println(list);

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList("AA", "BB", "CC");
        list.addAll(2, list1);
        System.out.println(list);

    }

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i, (int) (Math.random() * 100));
        }
        list.add(5, 10);

        System.out.println(list);
        //查：get(int index):获取在index位置的元素
        Object o = list.get(4);
        System.out.println(o);

        //int indexOf(Object obj):返回obj在集合中首次出现的位置。如果不存在，返回-1.
        System.out.println(list.indexOf(10));

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置。如果不存在，返回-1.
        System.out.println(list.lastIndexOf(45));

        //删：Object remove(int index):移除指定index位置的元素，并返回此元素(对List集合)
        Object o1 = list.remove(5);
        System.out.println(o1);


        //改：Object set(int index, Object ele):设置指定index位置的元素为ele
        System.out.println(list.set(2, 10));

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开区间的子集合
        System.out.println(list.subList(1, 5));
    }

    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i, (int) (Math.random() * 100));
        }
        System.out.println(list);

        //遍历
        //方式一：Iterator迭代器方式遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----------------");

        //方式二：增强for循环方式
        for (Object obj : list) {
            System.out.println(obj);
        }
        System.out.println("-----------------");

        //方式三：普通for循环方式
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}