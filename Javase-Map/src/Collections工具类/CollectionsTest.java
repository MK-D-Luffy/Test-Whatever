package Collections工具类; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections:操作Collection(List、Set)、Map的工具类
 *
 * 面试题：Collection 和 Collections的区别？
 *
 * 排序操作(List):(返回值均为void)
 *  reverse(List)：反转 List 中元素的顺序
 *  shuffle(List)：对 List 集合元素进行随机排序
 *  sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 *  sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 *  swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
 * 查找、替换(Collection):
 *  Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 *  Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
 *  Object min(Collection)
 *  Object min(Collection，Comparator)
 *  int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 *  void copy(List dest,List src)：将src中的内容复制到dest中
 *  boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
 *
 * SynchronizedXxx(Collection、Map):
 *  Collections 类中提供了多个 synchronizedXxx() 方法，
 *  该方法可使将指定集合包装成线程同步的集合，从而可以解决
 *  多线程并发访问集合时的线程安全问题
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/22 8:56
 */
public class CollectionsTest {
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(1215);
        list.add(563);
        list.add(585);
        list.add(213);

        System.out.println(list);

        //反转：Collections.reverse(List)
        Collections.reverse(list);
        System.out.println(list);

        //打乱：Collections.shuffle(List);

        //(自然)排序：Collections.sort(List);
        //(定制)排序：Collections.sort(List，Comparator)
        Collections.sort(list);
        System.out.println(list);

        //交换数据：Collections.swap(list,1,2);

    }

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(43);
        list.add(-97);
        list.add(0);

        //void copy(List dest,List src)：将src中的内容复制到dest中
        //报异常：IndexOutOfBoundsException("Source does not fit in dest")
//        List dest = new ArrayList();
//        Collections.copy(dest,list);

        //正确的(要先确保dest中数据的长度足以放下src数据的长度，即要求满足：dest.size()>=src.size()！)：
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);

        //int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        int frequency = Collections.frequency(list, 123);
        System.out.println(frequency);

        //synchronizedXxx:将输入的集合(Collection、Map)变成线程安全的原集合输出。
        List list1 = Collections.synchronizedList(list);
        System.out.println(list1);
    }
}