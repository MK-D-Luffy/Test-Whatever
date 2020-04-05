package Java8新特性.强大的StreamAPI;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import Java8新特性.方法引用_构造器引用和数组引用.Employee;
import Java8新特性.方法引用_构造器引用和数组引用.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.什么是Stream:  (简单的说,就是一个对容器数据进行操作的API)
 *  Stream 作为 Java 8 的一大亮点，它与Java.io 包里的InputStream 和 OutputStream是完全不同的概念。
 *  Java 8 中的 Stream 是对集合（Collection）对象功能的增强，它专注于对集合对象进行各种非常便利、
 *  高效的聚合操作（aggregate operation），或者大批量数据操作 (bulk data operation)。
 *  Stream API 借助于同样新出现的 Lambda 表达式，极大的提高编程效率和程序可读性。
 *
 * 2.Stream流的深入理解和聚合操作: (!!!)
 *  首先要建立Stream和管道的概念，Stream 和Collection结构化的数据不一样，
 *  Stream是一系列的元素，就像是流水线上的罐头一样，一个个的出来。
 *  而对Stream执行的一系列操作称为聚合操作。
 *
 *  聚合操作就是指流水线上检验罐头是否达标并如何出厂的各种操作，有中间操作 和 终止操作。
 *
 *  管道: 而运输这些罐头并进行操作的称为管道。
 *
 * 3.Stream类的特点
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 *
 * 4.Stream 执行流程
 * ① Stream的实例化
 * ② 一系列的中间操作（过滤、映射、...)
 * ③ 终止操作
 *
 * 5.说明：
 * 5.1 一个中间操作链，对数据源的数据进行处理
 * 5.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 *
 *@author 今天也要努力的小白
 *@creat 2020/4/3 15:33
 */
public class Stream实例化测试 {

    //创建Stream对象方式一：通过集合

    @Test
    public void test1() {

        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();

    }

    //创建Stream对象方式二：通过数组

    @Test
    public void test2() {

        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流

        int[] arr = {1, 2, 3, 4};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jerry");
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);

    }

    //创建Stream对象方式三：通过Stream的of(T...values)
    @Test
    public void test3() {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

    }

    //创建Stream对象方式四：创建无限流
    @Test
    public void test4() {

//      迭代
//      public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);

//      生成
//      public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }

}