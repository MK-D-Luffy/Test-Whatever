package Map常用方法; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * 五、Map中定义的方法：
 *  添加、删除、修改操作：
 *      Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *      void putAll(Map m):将m中的所有key-value对存放到当前map中
 *      Object remove(Object key)：移除指定key的key-value对，并返回value
 *      void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *      Object get(Object key)：获取指定key对应的value
 *      boolean containsKey(Object key)：是否包含指定的key
 *      boolean containsValue(Object value)：是否包含指定的value
 *      int size()：返回map中key-value对的个数
 *      boolean isEmpty()：判断当前map是否为空
 *      boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *      Set keySet()：返回所有key构成的Set集合
 *      Collection values()：返回所有value构成的Collection集合
 *      Set entrySet()：返回所有key-value对构成的Set集合
 *
 *  总结：常用方法：
 *    添加：put(Object key,Object value)
 *    删除：remove(Object key)
 *    修改：put(Object key,Object value)
 *    查询：get(Object key)
 *    长度：size()
 *    遍历：keySet() / values() / entrySet()
 *
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/21 19:34
 */
public class MapMethodTest {
    /*
     *  添加、删除、修改操作：
     *      Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     *      void putAll(Map m):将m中的所有key-value对存放到当前map中
     *      Object remove(Object key)：移除指定key的key-value对，并返回value
     *      void clear()：清空当前map中的所有数据
     */

    @Test
    public void test1() {
        Map map = new HashMap();
        //添加：put(Object key,Object value)
        map.put("aa",123);
        map.put(45,523);
        map.put("bb",56);
        //修改：put(Object key,Object value)
        map.put("aa",55);
        System.out.println(map);

        //添加：putAll(Map m)
        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);
        map.putAll(map1);
        System.out.println(map);

        //删除：remove(Object key)
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        //清空：clear()
        map.clear();//将map中的数据清空,与map = null操作不同。
        System.out.println(map.size());
        System.out.println(map);

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set entrySet = linkedHashMap.entrySet();
    }

    /*
    *   元素查询的操作：
    *       Object get(Object key)：获取指定key对应的value
    *       boolean containsKey(Object key)：是否包含指定的key
    *       boolean containsValue(Object value)：是否包含指定的value
    *       int size()：返回map中key-value对的个数
    *       boolean isEmpty()：判断当前map是否为空
    *       boolean equals(Object obj)：判断当前map和参数对象obj是否相等。
    */

    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        // 查找：Object get(Object key)
        System.out.println(map.get(45));

        //containsKey(Object key)
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);

        //containsValue(Object value)
        isExist = map.containsValue(123);
        System.out.println(isExist);

        map.clear();
        //isEmpty()
        System.out.println(map.isEmpty());

        //equals(Object obj):判断当前map和参数对象obj(Map集合)是否相等。

    }
    /*
     *  元视图操作的方法(遍历)：
     *      Set keySet()：返回所有key构成的Set集合。
     *      Collection values()：返回所有value构成的Collection集合。
     *      Set entrySet()：返回所有key-value对构成的Set集合。
     */

    @Test
    public void test3() {
        Map map = new HashMap();
        map.put(123,1230);
        map.put("wqihfk","3220sad");
        map.put(2223210,"sdad");
        map.put("dass","asdw23352");

        //遍历所有的key集：Set keySet()：返回所有key构成的Set集合。
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();

        //遍历所有的value集：Collection values()：返回所有value构成的Collection集合。
        Collection values = map.values();
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println();

        //遍历所有的key-value：
        //方式一：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()){
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) iterator2.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"--->"+value);
        }
        System.out.println();

        //方式二：通过遍历key集,调用map.get(key)获取value集。
        Set set1 = map.keySet();
        Iterator iterator3 = set1.iterator();
        while (iterator3.hasNext()){
            Object keySet = iterator3.next();
            System.out.println(keySet+"--->"+map.get(keySet));
        }
    }
}