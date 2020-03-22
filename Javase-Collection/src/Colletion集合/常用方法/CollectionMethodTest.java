package Colletion集合.常用方法; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import Colletion集合.Person;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 三、Collection接口中的方法的使用
 * <p>
 * 结论（要求）：（因为集合的大部分方法操作如contain(),remove（）等都会调用equals（）来对其进行辅助操作）
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 *
 * Collection接口中的方法：
 *
 * 1.add(E e) 元素e添加到集合coll中。
 * 2.addAll(Collection coll1 )将coll1集合中的元素添加到当前的集合中。
 * 3.size():获取其中的(添加的)元素的个数。
 * 4.clear():清空集合元素。
 * 5.isEmpty():判断当前集合是否为空。(即集合内有无元素)
 *
 * 1.contains(Object obj):判断当前集合中是否包含obj.
 * 2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
 * 3.remove(Object obj):从当前集合中移除obj元素。（使用remove一次只能移除对应的一个元素）
 * 4.removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
 * 5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合。
 * 6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。
 * 7.hashCode():返回当前对象的哈希值。
 * (!!!)                        toArray()
 * 8.   集合（List是动态数组）   --------->     数组
 *                Arrays.asList()
 *      数组       ---------->       集合(List --> Collection（List）)
 *
 * 9.iterator():返回Iterator接口的实例，用于遍历集合元素。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/18 16:56
 */
public class CollectionMethodTest {
    @Test
    public void testMethod1() {
        Collection coll = new ArrayList();

        //1.add(Object e):将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱(集合内存放的都是对象)
        coll.add(new Date());

        //2.addAll(Collection coll1):将coll1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        //3.size():获取其中的(添加的)元素的个数
        System.out.println(coll.size());

        //4.clear():清空集合元素
        coll.clear();

        //5.isEmpty():判断当前集合是否为空(即集合内有无元素)
        System.out.println(coll.isEmpty());

    }

    @Test
    public void testMethod2() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //1.contains(Object obj):判断当前集合中是否包含obj.
        //我们在判断时会调用obj对象所在类的equals()。
        System.out.println(coll.contains(123));

        //String类本身在定义前底层就已经重写了equals（）方法。
        System.out.println(coll.contains(new String("Tom")));

        //重写equals（）后,由原本的 false ---> true
        System.out.println(coll.contains(new Person("Jerry", 20)));

        //2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
        Collection coll1 = Arrays.asList(123, 4567);
        System.out.println(coll.containsAll(coll1));

    }

    @Test
    public void testMethod3() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(new Person("Jerry", 20));
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //3.remove(Object obj):从当前集合中移除obj元素。（使用remove一次只能移除对应的一个元素）
        boolean remove = coll.remove(123);
        System.out.println(coll);

        //一次只能移除一个元素
        coll.remove(new Person("Jerry", 20));
        System.out.println(coll);

        //4. removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
        Collection coll1 = Arrays.asList(123, new Person("Jerry", 20));
        coll.removeAll(coll1);
        System.out.println(coll);

    }

    @Test
    public void testMethod4() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
        Collection coll1 = Arrays.asList(123, 456, 789);
        coll.retainAll(coll1);
        System.out.println(coll);

        //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。
        //在List中要求两个集合间顺序也要相同，而在Set中顺序无需相同（具体情况具体分析！）
        Collection coll2 = new ArrayList();
        coll1.add(456);
        coll1.add(123);
        coll1.add(new Person("Jerry", 20));
        coll1.add(new String("Tom"));
        coll1.add(false);

        System.out.println(coll.equals(coll2));
    }

    @Test
    public void testMethod5() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 --->数组：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组 --->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1,将int[]当作一个对象传入，因为集合的元素不能为基本数据类型（int）。

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试

    }
}