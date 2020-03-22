/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * TreeMap介绍（与TreeSet基本类似）：
 *  向TreeMap中添加key-value，要求key必须是同一个类创建的对象
 *  因为要按照key进行排序：自然排序 、定制排序
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/22 8:10
 */
public class TreeMapTest {
    //自然排序
    @Test
    public void test1() {
        //TreeMap按key排序
        TreeMap treeMap = new TreeMap();
        treeMap.put(new User("xiaohong",15),12);
        treeMap.put(new User("laoliu",85),13);
        treeMap.put(new User("erge",100),14);

        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }
    }

    @Test
    public void test2() {
        //TreeMap按key排序
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User&&o2 instanceof User){
                    User user1 = (User) o1;
                    User user2= (User) o2;
                    return user1.getName().compareTo(user2.getName());
                }else {
                    throw new RuntimeException("您输入的类型不匹配");
                }
            }
        });
        treeMap.put(new User("xiaohong",15),12);
        treeMap.put(new User("laoliu",85),13);
        treeMap.put(new User("erge",100),14);

        Set keySet = treeMap.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();
            Object value = treeMap.get(key);
            System.out.println(key+"--->"+value);
        }
    }
}