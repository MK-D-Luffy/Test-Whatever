package Java8新特性.λ表达式;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import Java8新特性.方法引用_构造器引用和数组引用.Employee;
import Java8新特性.方法引用_构造器引用和数组引用.EmployeeData;

import java.util.Collections;
import java.util.List;

/**
 * @author 今天也要努力的小白
 * @creat 2020/4/3 16:59
 */
public class LambdaTest {
    //1.调用Collections.sort()方法，通过定制排序比较两个Employee(先按
//年龄比，年龄相同按姓名比),使用Lambda 表达式作为参数传递。

    @Test
    public void test1() {

        List<Employee> list = EmployeeData.getEmployees();

        Collections.sort(list, (o1, o2) -> {
            if ((o1 != null) && (o2 != null)) {
                if (o1.getAge() == o2.getAge()) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return Integer.compare(o1.getAge(), o2.getAge());
                }
            }
            throw new RuntimeException("比较的类不匹配");
        });

        list.forEach(System.out::println);

    }

    //2.  ①声明函数式接口，接口中声明抽象方法：public String getValue(String str);
//    ②声明类 LambdaTest，类中编写方法使用接口作为参数，将一个
//    字符串转换成大写，并作为方法的返回值。
//    ③再将一个字符串的第2 个到第4 个索引位置进行截取子串。

    public String method(String str, @NotNull func fun) {
        return fun.getValue(str);
    }

    @Test
    public void test2() {
        String s = method("abc", str -> str.toUpperCase().substring(2, 5));
        System.out.println(s);
    }


    //3.  ①声明一个带两个泛型的函数式接口，泛型类型为<T,R>  :  T  为参数，R  为返回值。
//    ②接口中声明对应抽象方法
//    ③在LambdaTest 类中声明方法，使用接口作为参数，计算两个long型参数的和。
//    ④再计算两个long 型参数的乘积

    @Test
    public void test3() {
        long l1 = 1L;
        long l2 = 2L;
        calculate(l1, l2, (x, y) -> x + y);
    }

    public void calculate(long l1, long l2, Func<Long, Long> func) {
        System.out.println(func.getValue(l1, l2));
    }

//    public void calculate(long l1,long l2,BiFunction<Long,Long,Long> bif) {
//
//    }

}

@FunctionalInterface
interface func {
    public String getValue(String str);
}


@FunctionalInterface
interface Func<T, R> {
    public R getValue(T t1, T t2);
}

