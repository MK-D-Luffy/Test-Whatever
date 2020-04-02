package Set集合.Treeset的课后练习_$使用泛型了$_;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 *  创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
 *  分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 *
 *  1). 使Employee 实现 Comparable 接口，并按 name 排序
 *  2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/21 9:20
 */
public class TreeSetExercise {
    @Test
    public void test() {

        Comparator<Employee> comparator = new Comparator<>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate myDate1=o1.getBirthday();
                MyDate myDate2=o2.getBirthday();
                if (myDate1.getYear() == myDate2.getYear()) {
                    if (myDate1.getMonth() == myDate2.getMonth()) {
                        if (myDate1.getDay() != myDate2.getDay()) {
                            return Integer.compare(myDate1.getDay(), myDate2.getDay());
                        } else {
                            return 0;
                        }
                    } else {
                        return Integer.compare(myDate1.getMonth(), myDate2.getMonth());
                    }
                } else {
                    return Integer.compare(myDate1.getYear(), myDate2.getYear());
                }
            }
        };

//            @Override
//            public int compare(Employee o1, Employee o2) {
//                    MyDate b1 = o1.getBirthday();
//                    MyDate b2 = o2.getBirthday();
////                    方式一：
//                    //比较年
//                    int minusYear = b1.getYear() - b2.getYear();
//                    if(minusYear != 0){
//                        return minusYear;
//                    }
//                    //比较月
//                    int minusMonth = b1.getMonth() - b2.getMonth();
//                    if(minusMonth != 0){
//                        return minusMonth;
//                    }
//                    //比较日
//                    return b1.getDay() - b2.getDay();
//
//                    //方式二：
//                   // return b1.compareTo(b2);
//
//                }
//                return 0;

        TreeSet<Employee> employees = new TreeSet<>(comparator);
        employees.add(new Employee("xiaozhang",12,new MyDate(2012,8,12)));
        employees.add(new Employee("Harry",20,new MyDate(2000,2,15)));
        employees.add(new Employee("Mary",13,new MyDate(2007,5,24)));
        employees.add(new Employee("kunfu",52,new MyDate(1978,12,11)));
        employees.add(new Employee("xiaoli",22,new MyDate(1998,11,11)));

        employees.forEach(System.out::println);

    }
}