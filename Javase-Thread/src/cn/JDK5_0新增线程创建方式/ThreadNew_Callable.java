package cn.JDK5_0新增线程创建方式;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。----JDK 5.0新增
 * 1.创建一个实现Callable的实现类。
 * 2.实现call（）方法，将此线程需要执行的操作声明在call（）中。
 * 3.创建Callable接口实现类的对象。
 * 4.将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象。
 * 5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start（）方法以启动线程。
 * 6.获取Callable中的call方法的返回值。（futureTask中调用的get，获取call的返回值）
 * <p>
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程强大？
 * 1.call（）方法是可以有返回值的
 * 2.call（）方法是可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3.Callable是支持泛型的
 *
 * @author 今天也要努力的小白
 * @date 2020/3/12 9:41
 */
//1. 创建一个实现Callable的实现类
class Number implements Callable<Integer> {
    //2.实现call（）方法，将此线程需要执行的操作声明在call（）中
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew_Callable {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        Number number = new Number();

        //4.将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask<Integer> futureTask = new FutureTask<>(number);

        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start（）方法（）
        new Thread(futureTask).start();

        try {
            //6.获取Callable中的call方法的返回值（futureTask中调用的get，获取call的返回值）
            //get（）返回值即为FutureTask的构造器参数Callable实现类重写的call（）的返回值
            Integer sum = futureTask.get();
            System.out.println("总和为:" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
