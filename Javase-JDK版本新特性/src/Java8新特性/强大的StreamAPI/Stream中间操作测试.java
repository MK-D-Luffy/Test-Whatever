package Java8新特性.强大的StreamAPI;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import Java8新特性.方法引用_构造器引用和数组引用.Employee;
import Java8新特性.方法引用_构造器引用和数组引用.EmployeeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @author 今天也要努力的小白
 * @creat 2020/4/4 8:52
 */
public class Stream中间操作测试 {

    //1-筛选与切片
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();

//        filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        //练习：查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println();

//        limit(n)——截断流，使其元素不超过给定数量。
        employees.stream().limit(5).forEach(System.out::println);
        System.out.println();

//        skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        employees.stream().skip(4).limit(2).forEach(System.out::println);
        System.out.println();

//        distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 41, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));

        employees.stream().distinct().forEach(System.out::println);

    }


    //映射

    /**
     * map: 传入一个元素返回一个元素
     *   map函数式接口抽象方法的返回值是R
     * flatMap: 传入一个元素返回一个Stream对象
     *  flatMap函数式接口抽象方法返回值是Stream< R >
     *
     * 所以flatMap作用就是将返回的Stream< R >拆开，再将里面的每个值组合成为新的Stream< R >
     *
     */
    @Test
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();

//        map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，
//        该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

//        练习1：获取员工姓名长度大于3的员工的姓名。
        employees.stream().map(e -> e.getName()).filter(name -> name.length() > 3).
                forEach(System.out::println);

        employees.stream().map(employee -> employee.getName().length()>3).
                forEach(System.out::println);


        list = Arrays.asList("aa", "bb", "cc", "dd");
        //练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(Stream中间操作测试::fromStringToStream);
        streamStream.forEach(s ->{
            s.forEach(System.out::println);
        });
        System.out.println();

//        flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，
//        然后把所有流连接成一个流。
        Stream<Character> characterStream = list.stream().flatMap(Stream中间操作测试::fromStringToStream);
        characterStream.forEach(System.out::println);

    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){//aa
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }


    //3-排序
    @Test
    public void test3() {
//        sorted()——自然排序
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);
        //抛异常，原因:Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);


//        sorted(Comparator com)——定制排序

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> {

            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0) {
                return ageValue;
            } else {
                return -Double.compare(e1.getSalary(), e2.getSalary());
            }

        }).forEach(System.out::println);

    }

}