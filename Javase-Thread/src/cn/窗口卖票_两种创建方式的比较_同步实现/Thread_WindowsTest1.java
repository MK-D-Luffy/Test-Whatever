package cn.窗口卖票_两种创建方式的比较_同步实现;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 例子：创建三个窗口卖票，总票数为100张。使用实现Runnable接口的方式
 * <p>
 * 存在线程的安全问题，待解决。
 *
 * 比较创建线程的两种方式。
 * 开发中：优先选择：实现Runnable接口的方式
 * 原因：1. 实现的方式没有类的单继承性的局限性
 *      2. 实现的方式更适合来处理多个线程有共享数据的情况。
 *
 * 联系：public class Thread implements Runnable
 * 相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中。
 *
 *
 * @author 今天也要努力的小白
 * @date 2020/3/10 10:51
 */
public class Thread_WindowsTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();

        Thread thread1 = new Thread(window1,"线程1");
        Thread thread2 = new Thread(window1,"线程2");
        Thread thread3 = new Thread(window1,"线程3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class Window1 implements Runnable {
    //只创建了一个窗口实例对象，其他线程是基于该对象创建的不同线程对象
    //因为该数据相当于是共享数据，所以在定义时可以不用加static，直接如下定义即可。
    private int ticket = 100;

    @Override
    public void run() {
        for (ticket = 100; ticket > 0; ticket--) {
            System.out.println(Thread.currentThread().getName()+":"+ticket);
        }
    }
}

