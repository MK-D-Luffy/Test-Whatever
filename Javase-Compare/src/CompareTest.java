/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
 *          但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
 *          如何实现？使用两个接口中的任何一个：Comparable 或 Comparator
 *
 * 二、Comparable接口与Comparator的使用的对比：
 *        Comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
 *        Comparator接口属于临时性的比较。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/16 15:04
 */
public class CompareTest {
    /*
    Comparable接口的使用举例：  自然排序
    1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。
    2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
    3.重写compareTo(obj)的规则：
        如果当前对象this大于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回负整数，
        如果当前对象this等于形参对象obj，则返回零。
    4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。
        在compareTo(obj)方法中指明如何排序

    */
    @Test
    public void test1() {
        Integer[] in = new Integer[]{1, 5, 2, 3};
        Arrays.sort(in);
        System.out.println(Arrays.toString(in));
    }

    @Test
    public void test2() {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("xiaomi", 10);
        goods[1] = new Goods("huawei", 52);
        goods[2] = new Goods("sanxing", 45);
        goods[3] = new Goods("apple", 65);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    /*
    Comparator接口的使用：定制排序
    1.背景：
    当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
    或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
    那么可以考虑使用 Comparator 的对象来排序
    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
        如果方法返回正整数，则表示o1大于o2；
        如果返回0，表示相等；
        返回负整数，表示o1小于o2。

    */
    @Test
    public void test3() {
        Integer[] in = new Integer[]{1, 5, 2, 3};
        //按照整型从大到小的顺序排列
        Arrays.sort(in, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(in));
    }

    @Test
    public void test4() {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("xiaomi", 10);
        goods[1] = new Goods("huawei", 52);
        goods[2] = new Goods("sanxing", 45);
        goods[3] = new Goods("apple", 65);
        goods[4] = new Goods("sanxing7pro", 45);
        //指明商品比较大小的方式:按照产品名称从低到高排序,再按照价格从高到低排序
        Arrays.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                //第一优先级排序，如果相等，比较第二优先级，以此类推。
                if (Integer.compare(o1.getPrice(), o2.getPrice()) == 0) {
                    return o1.compareTo(o2);
                }else {
                    //第一优先级不相等，就可以直接排序了，不用再比较别的了，直接返回排序结果就行了。
                    return Integer.compare(o1.getPrice(), o2.getPrice());
                }
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}