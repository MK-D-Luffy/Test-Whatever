/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

/**
 * 一、Map的实现类的框架：
 *  |----Map:双列数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
 *         |----HashMap:作为Map的主要实现类；线程不安全的，效率高；存储null的key和value
 *              |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *                      原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                      对于频繁的遍历操作，此类执行效率高于HashMap。
 *         |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *                      底层使用红黑树
 *         |----Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
 *              |----Properties:常用来处理配置文件。key和value都是String类型
 *
 *      HashMap的底层：数组+链表  （jdk7及之前）
 *                    数组+链表+红黑树 （jdk 8）
 *
 *  为什么说对于频繁的遍历操作，LinkedHashMap执行效率高于HashMap？（线性探测！）
 *      HashMap的数据有空位置参与，因为有负载因子，很大概率无法全部填满。
 *      而LinkedHashMap是由双向的上下位置确定的，在遍历上效率应该略高一筹。
 *
 *  面试题：
 *  1. HashMap的底层实现原理？（!!!）
 *  2. HashMap 和 Hashtable的异同？
 *  3. CurrentHashMap 与 Hashtable的异同？（暂时不讲）
 *
 *  二、Map<key,value>结构的理解：
 *    Map中的key:无序的、不可重复的，使用Set存储所有的key ---> key所在的类要重写equals()和hashCode() （以HashMap为例）
 *    Map中的value:无序的、可重复的，使用Collection存储所有的value ---> value所在的类要重写equals()
 *    一个键值对：key-value构成了一个Entry对象。
 *    Map中的Entry:无序的、不可重复的，使用Set存储所有的Entry。
 *
 *
 * 三、HashMap的底层实现原理？(!!!)
 *  以JDK7为例说明：
 *    HashMap map = new HashMap();
 *    当创建一个HashMap的对象时，底层会创建一个长度是16的一维数组Entry[]。
 *    ...可能已经执行过多次put...
 *    map.put(key1,value1);
 *    当map添加元素时，会先通过调用key1所在类的hashCode()计算并获取key1的hash值，然后将该hash值通过某种算法，
 *    计算出key在数组中的索引位置（即存放位置）。
 *    1)①如果该位置没有数据(即为空)时，此时的key1-value1添加成功。
 *      ②如果该位置有一个或多个用链表存储的数据（不为空）时，将key1与其中的数据的hash值进行比较：
 *        2)①如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。
 *          ②如果存在一个hash值相等的键值对<key2,value2>,在调用equals()进行比较
 *           3)①如果equals()返回false:此时key1-value1添加成功+
 *             ②如果equals()返回true:使用value1替换value2。
 *
 *      补充：关于情况(2)和情况(3)：此时key1-value1和原来的数据以链表的方式存储。(和HashSet类似)
 *
 *      在不断的添加过程中，会涉及到扩容问题，当超出临界值即负载值(且要存放的位置非空)时，扩容。
 *      默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
 *
 *   jdk8 相较于jdk7在底层实现方面的不同（!!!）：
 *      1. new HashMap():底层没有创建一个长度为16的数组（和ArrayList类似）
 *      2. jdk 8底层的数组是：Node[],而非Entry[]
 *      3. 首次调用put()方法时，底层创建长度为16的数组
 *      4. jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
 *         4.1 形成链表时，七上八下（jdk7:头插法、jdk8：尾插法）
 *         4.2 当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，
 *         此时此索引位置上的所数据改为使用红黑树存储。
 *
 *      DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *      DEFAULT_LOAD_FACTOR：HashMap的默认负载因子：0.75
 *      threshold：扩容的临界值 = 容量*填充因子：16 * 0.75 => 12
 *      table：底层存储元素的数组，总是2的n次幂。
 *      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值(8)且数组长度大于64时，转化为红黑树。
 *      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64
 *
 *
 *  四、LinkedHashMap的底层实现原理（了解）
 *      继承于HashMap，当调用put方法时，直接使用了父类HashMap的put方法，并再次调用父类的putVal方法，
 *      但LinkedHashMap重写了父类的newNode方法，当调用生成链表元素时本身还会维护一个双向链表。
 *      源码中（LinkedHashMap中的Entry）：
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
 *          Entry<K,V> before, after;//能够记录添加的元素的先后顺序
 *          Entry(int hash, K key, V value, Node<K,V> next) {
 *              super(hash, key, value, next);
 *          }
 *      }
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/21 10:36
 */