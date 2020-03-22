package Colletion集合.集合概述; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 一、集合框架的概述
 * <p>
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 * 说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 * <p>
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *      比如：String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用。
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 * <p>
 * <p>
 * 二、集合框架
 * |----Collection接口：单列集合，用来存储一个一个的对象
 *      |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *          |----ArrayList、LinkedList、Vector
 * <p>
 *      |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *          |----HashSet、LinkedHashSet、TreeSet
 * <p>
 * |----Map接口：双列集合，用来存储一对(key - value)一对的数据   -->高中函数：y = f(x)
 *      |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 * <p>
 *
 * 三、Collection接口中的方法的使用
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/18 16:56
 */
public class CollectionTest {

}
