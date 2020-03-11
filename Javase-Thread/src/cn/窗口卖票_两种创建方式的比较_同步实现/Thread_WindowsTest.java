package cn.窗口卖票_两种创建方式的比较_同步实现;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 使用同步代码块解决继承于Thread类的方式的线程安全问题
 * <p>
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 * <p>
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 *      采用继承的方式创建，this大部分情况下不能使用。
 *
 * @author 今天也要努力的小白
 * @date 2020/3/10 10:51
 */
public class Thread_WindowsTest {
    public static void main(String[] args) {
        Window window1 = new Window("窗口1");
        Window window2 = new Window("窗口2");
        Window window3 = new Window("窗口3");
        window1.start();
        window2.start();
        window3.start();

    }
}

class Window extends Thread {
    private static int ticket = 100;
    //创建静态变量，同步代码块操作必须要用同一把锁。（即该锁是共享的！）
    private static String str="";

    @Override
    public void run() {
        synchronized (str) {//可以选择用Window.class, Class cla= Window.class，这个只能创建一个Window.class，即唯一。
            for (; ticket > 0; ticket--) {
                System.out.println(Thread.currentThread().getName() + ":" + ticket);
            }
        }
    }

    public Window(String name) {
        super(name);
    }
}
