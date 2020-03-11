package cn.用同步的方式解决窗口卖票的不安全性;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁 --- JDK5.0新增
 *
 * 1.面试题：synchronized 和 lock 的异同？
 * 相同：二者都可以解决线程安全问题。
 * 不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *      Lock需要手动的启动同步（lock（）），同时也需要去手动的结束同步（unlock（））
 *
 * 2.开发优先使用顺序：
 * Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体中除外）
 *
 * 面试题：如何解决线程安全问题？有几种方式
 *
 * @author 今天也要努力的小白
 * @date 2020/3/11 15:47
 */
class Windows implements Runnable {
    private int ticket = 100;
    //实例化ReentrantLock对象
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            //必须放在try/finally语句中，以免程序出现异常出现无法解锁的情况
            try {
                //2.调用锁定方法lock()
                lock.lock();

                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(ticket);
                } else {
                    break;
                }
                ticket--;

            }finally {
                //3.调用解锁方法unlock（）
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Windows windows = new Windows();

        Thread thread1 = new Thread(windows);
        Thread thread2 = new Thread(windows);
        Thread thread3 = new Thread(windows);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
