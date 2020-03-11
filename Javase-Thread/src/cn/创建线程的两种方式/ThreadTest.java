package cn.创建线程的两种方式;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * @author 今天也要努力的小白
 * @date 2020/3/9 21:36
 */
public class ThreadTest {
    public static void main(String[] args) {
        FirstWayTOCreatThread firstWay = new FirstWayTOCreatThread();

        //start()方法的作用:①启动当前线程 ②调用当前线程的run（）方法
        firstWay.start();

        //问题一：我们不能通过直接调用run（）方法的方式启动线程！
//        firstWay.run();

        //问题二：不能直接再次调用该线程，不能让已经启动start（）方法的线程再去启动一次，会报IllegalThreadStateException
//        firstWay.start();
        //如果要调用我们需要重新创建一个新的线程对象
        FirstWayTOCreatThread firstWay1 = new FirstWayTOCreatThread();
        firstWay1.start();


        //如下操作仍然再main中执行，上面start（）的部分是再那个线程中执行的！
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":  " + i);
        }

    }
}

