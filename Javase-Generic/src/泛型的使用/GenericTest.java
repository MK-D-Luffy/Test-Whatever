package 泛型的使用;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * 为什么要有泛型？直接Object不是也可以存储数据吗？
 *  1. 解决元素存储的安全性问题，好比商品、药品标签，不会弄错。
 *    （没有泛型任何类型都可以添加到集合中：类型不安全。）
 *  2. 解决获取数据元素时，需要类型强制转换的问题，好比不用每回拿商品、
 *     药品都要辨别。 （读取出来的对象需要强转：繁琐。）
 *
 * 泛型的使用
 *  1.JDK 5.0新增的特性.
 *
 *  2.在集合中使用泛型：
 *   总结：
 *   ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 *   ② 在实例化集合类时，可以指明具体的泛型类型
 *   ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，
 *     都指定为实例化的泛型类型。 比如：add(E e)  --->实例化以后：add(Integer e).
 *   ④ 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 *   ⑤ 如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 *
 *  3.如何自定义泛型结构：泛型类、泛型接口；泛型方法。见 CustomGenericTest.java
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/23 10:45
 */
public class GenericTest {

    //在集合中使用泛型之前的情况：
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
//        list.add("Tom");

        for(Object score : list){
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;

            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test2(){
        ArrayList<Integer> list =  new ArrayList<>();
        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
        //编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");

        //方式一：
//        for(Integer score : list){
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        //方式二：
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    @Test
    public void test3() {
        //HashMap<String,Integer> map = new HashMap<String,Integer>();
        //jdk7新特性：类型推断
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ds",12);
        map.put("2131sad",521);
        map.put("asdjwj",215);
//        map.put(123, 123);

        //泛型的嵌套
        Set<Map.Entry<String,Integer>>entrySet= map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"--->"+value);
        }
    }
}