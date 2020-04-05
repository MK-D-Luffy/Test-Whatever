package Java8新特性.强大的StreamAPI.课后练习;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 今天也要努力的小白
 * @creat 2020/4/3 15:19
 */
public class Exercises {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    //找出2011年发生的所有交易，并按交易额排序
    @Test
    public void test1() {
        transactions.stream().filter(t -> t.getYear() == 2011).map(Transaction::getValue).
                sorted(Integer::compare).forEach(System.out::println);

    }


    //交易员在哪些不同的城市工作过
    @Test
    public void test2() {

        Set<String> set = transactions.stream().
                map(t -> t.getTrader().getCity()).
                collect(Collectors.toSet());
        System.out.println(set);

        Set<String> set1 = transactions.stream().
                flatMap(t -> streamTransition(t.getTrader().getCity())).
                collect(Collectors.toSet());
        System.out.println(set1);
    }

    public <T> Stream<T> streamTransition(T t) {
        return Stream.of(t);
    }


    //查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test3() {

        transactions.stream()
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName)
                        .thenComparing(Trader::getCity))
                .forEach(System.out::println);

    }




    //返回所有交易员的姓名字符串，并按字母顺序排序
    @Test
    public void test4() {

        transactions.stream()
                .flatMap(t->transition(t.getTrader().getName()))
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        transactions.stream().
                map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    public Stream<Character> transition(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }

        return list.stream();

    }


    //有没有交易员在米兰工作的？
    @Test
    public void test5() {

        boolean anyMatch = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .anyMatch("Milan"::equals);

        System.out.println(anyMatch);

    }


    //打印生活在剑桥的交易员的所有交易额
    @Test
    public void test6() {

        transactions.stream()
                .map(Transaction::getValue)
                .sorted()
                .forEach(System.out::println);

    }


    //所有交易中，最高的交易额是多少
    @Test
    public void test7() {

        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);

        max.ifPresent(System.out::println);

    }


    //找到交易额最小的交易
    @Test
    public void test8() {

        Optional<Integer> min = transactions.stream()
                .map(Transaction::getValue)
                .min(Integer::compareTo);

        min.ifPresent(System.out::println);

    }

}