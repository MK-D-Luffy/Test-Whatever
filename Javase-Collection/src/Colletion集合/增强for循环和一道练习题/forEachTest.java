package Colletion集合.增强for循环和一道练习题; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import Colletion集合.Person;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * JDK 5.0 中新增foreach循环，用于遍历集合、数组。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/19 23:17
 */
public class forEachTest {
    //遍历集合
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合元素的类型 局部变量 : 集合对象)
        //内部仍然调用了迭代器。
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    //遍历数组
    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        //for(数组元素的类型 局部变量 : 数组对象)
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //练习题(考察了String的不可变性)
    @Test
    public void test3() {
        String[] arr = new String[]{"MM", "MM", "MM"};

//        //方式一：普通for赋值
//        //普通for循环：使用本身的数据进行操作
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = "GG";
//        }

        //方式二：增强for循环
        //增强for循环：从arr[]中取出元素，将其赋值给局部变量s，然后再操作s，不会对原数组产生影响。（!!!）
        for (String s : arr) {
            s = "GG";
        }

        System.out.println(Arrays.toString(arr));
    }
}
