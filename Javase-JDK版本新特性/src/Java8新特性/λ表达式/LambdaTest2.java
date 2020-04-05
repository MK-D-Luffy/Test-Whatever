package Java8新特性.λ表达式; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 *
 * @author 今天也要努力的小白
 * @creat 2020/4/3 9:34
 */
public class LambdaTest2 {

    //消费型接口 Consumer<T>演示

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test1() {

        happyTime(400, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("花费了" + aDouble + "元");
            }
        });

        happyTime(500, (money) -> System.out.println("消费了" + money + "元"));

    }


    //供给型接口 Supplier<T>演示

    public String getSupplier(Supplier<String> str) {
        return str.get()+"是一个不求回报的供给型";
    }

    @Test
    public void test2() {

        String s = getSupplier(() -> "我");

        System.out.println(s);
    }


    //函数型接口 Function<T,R>演示

    public void method(String name, String password, Function<String, String> encrypt) {
        System.out.println(encrypt.apply(password));
    }

    @Test
    public void test3() {

        method("张三", "abc123", (before) -> {
            StringBuilder after = new StringBuilder();
            for (int i = 0; i < before.length(); i++) {
                after.append(before.charAt(i) ^ 5);
            }
            return after.toString();
        });

    }


    //断定型接口 Predicate<T>演示

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){

        ArrayList<String> filterList = new ArrayList<>();

        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;

    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京");

        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(filterStrs);


        List<String> filterStrs1 = filterString(list, s -> s.contains("京"));
        System.out.println(filterStrs1);
    }

}