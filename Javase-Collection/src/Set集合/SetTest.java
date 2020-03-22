package Set集合;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1. Set接口的框架：
 *
 * |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *              |----HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值
 *                  |----LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
 *                                      对于频繁的遍历操作，LinkedHashSet效率高于HashSet.
 *              |----TreeSet：可以按照添加对象的指定属性，进行排序。
 *
 *
 *  1. Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法。
 *
 *  2. 要求1：向Set(主要指：HashSet、LinkedHashSet)中添加的数据，其所在的类一定要重写hashCode()和equals()
 *     要求2：重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码(也叫哈希值)
 *     重写两个方法的小技巧：对象中用作 equals() 方法比较的属性，都应该用来计算 hashCode 值。(这样能保证一致性)
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/20 16:21
 */
public class SetTest {
    /*
    一：Set：存储无序的、不可重复的数据
    以HashSet为例说明底层源码实现：
    1.无序性：不等于随机性。存储的数据在底层中并非按照数组索引的顺序添加，而是根据数据的哈希值。

    2.不可重复性：保证添加的元素按照equals（）判断时，不能返回true。即：相同的元素只能添加一个。

    二：添加元素的过程：以HashSet为例：
        我们向HashSet中添加元素a，首先通过调用元素a所在类的hashCode()方法取得元素a的hash值，然后此hash值
        再通过某种算法计算出元素a在该数组中的索引位置（即存放位置）。
        1）判断数组该位置上是否已经有元素：
            如果该索引位置没有元素了，那么将元素a添加到该位置，添加成功。
            如果该索引位置已经有元素b或多个链式存储的数据时。
            2）比较元素a与元素b（或多个存储数据）的hash值：
                如果元素a与其比较没有找到相同的hash值，则将元素a按七上八下的规则添加到该存放位置的链表中，添加成功。
                如果元素a找到了相同的hash值。
                3）用该元素去调用它们所在类的equals()方法，形参为元素a：
                    如果equals返回true，则添加失败
                    如果equals返回false，则将元素a按七上八下的规则添加到该存放位置的链表中,添加成功

        对存放位置已有数据以链表式添加元素：
        JDK7:元素a放到数组中，指向原来的元素。（头插法）
        JDK8:原来的元素还在数组中，指向元素a。（尾插法）
        总结：七上八下

    HashSet底层：数组+链表的结构。

     */

    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet的使用
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，也是根据元素hashCode值来决定元素存储位置，
    // 但它同时使用链表维护元素的次序，这样使得元素看起来是以插入的顺序保存的。
    //优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet，所以可以应用在对元素顺序有要求的场景中。
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
