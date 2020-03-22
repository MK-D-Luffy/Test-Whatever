package Colletion集合.迭代器模式; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import Colletion集合.Person;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法：hasNext() 和  next() 。
 * next（）方法作用：①指针下移 ②将下移以后集合位置的元素返回。(!!!)
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象,
 * 默认游标都在集合的第一个元素之前。
 * 3.内部定义了remove(),可以在遍历的时候,删除集合中的元素。即删除当前指针指向的元素,
 * 此方法不同于集合直接调用remove()。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/19 17:09
 */
public class IteratorTest {
    @Test
    public void testIterator() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

//        //方式一
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：NoSuchElementException
//        System.out.println(iterator.next());

//        //方式二:不推荐
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        //hasNext（）：判断是否还有下一个元素
        while (iterator.hasNext()) {
            //next（）方法作用：①指针下移 ②将下移以后集合位置的元素返回。
            System.out.println(iterator.next());
        }
    }

    //两个错误示范:
    @Test
    public void testWrong() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //错误方式一：
        //next（）方法作用：①指针下移 ②将下移以后集合位置的元素返回。(!!!)
//        Iterator iterator = coll.iterator();
//        while((iterator.next()) != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
        while (coll.iterator().hasNext()) {
            System.out.println(coll.iterator().next());
        }
    }

    //测试Iterator中的remove（）方法
    // 注意：如果还未调用next() 或 在上一次调用next()方法之后已经调用了remove()方法，
    // 再调用remove都会报IllegalStateException。
    @Test
    public void testRemove() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //删除集合中"Tom"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if ("Tom".equals(obj)) {
                iterator.remove();
            }
        }

        //遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}