package Set集合;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 1.向TreeSet中添加的数据，要求是相同类的对象。
 * 2.两种排序方式：自然排序（实现Comparable接口） 和 定制排序（Comparator）
 *
 * 3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals()。
 * 4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals()。
 * 注意：在二叉树中如果是相同元素就不会再次了输出，相同的元素只会被输出一次。
 *
 * TreeSet底层是红黑树实现的。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/20 20:02
 */
public class TreeSetTest {
    @Test
    public void test1() {
        TreeSet set = new TreeSet();

        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));

        //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：
        set.add(new User("Tom", 12));
        set.add(new User("Herry", 32));
        set.add(new User("Amy", 12));
        set.add(new User("Mike", 65));
        set.add(new User("Jack", 33));
        set.add(new User("Jack", 56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    @Test
    public void test2() {
        //使用Comparator对象进行定制排序.
        Comparator comparator = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                } else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        //public TreeSet(Comparator<? super E> comparator)
        TreeSet set = new TreeSet(comparator);
        set.add(new User("Tom", 12));
        set.add(new User("Herry", 32));
        set.add(new User("Amy", 12));
        set.add(new User("Mike", 65));
        set.add(new User("Jack", 33));
        set.add(new User("Jack", 56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}