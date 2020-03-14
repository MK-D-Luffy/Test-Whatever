package cn.JDK5_0新增线程创建方式;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四：使用线程池。
 * <p>
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理：（线程池属性的设置）
 *           corePoolSize：核心池的大小
 *           maximumPoolSize：最大线程数
 *           keepAliveTime：线程没有任务时最多保持多长时间后会终止
 * <p>
 * 面试题：创建多线程有几种方式？四种！
 *
 * @author 今天也要努力的小白
 * @date 2020/3/12 10:39
 */
class NumberThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

class NumberThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }
}

public class ThreadNew_ThreadPool {
    public static void main(String[] args) {
        //1.提供指定数量的线程池
        //Executors是工具类，ExecutorService是接口,实际上调用Executors返回的是ThreadPoolExecutor的类型
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池的属性
        service1.setCorePoolSize(5);
//      service1.setKeepAliveTime();

        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象。
        // execute（）和submit（）可以直接执行操作，无需再调start（）
        //1）适合用于Runnable（execute方法）
        service.execute(new NumberThread1());

        //2）适合用于Callable和Runnable（submit方法）
        service.submit(new NumberThread2());

        //3.关闭连接池
        service.shutdown();
    }
}
