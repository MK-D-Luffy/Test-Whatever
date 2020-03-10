package cn;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 * <p>
 * 存在线程的安全问题，待解决。
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

    @Override
    public void run() {
        for (ticket = 100; ticket > 0; ticket--) {
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
        }
    }

    public Window(String name) {
        super(name);
    }
}
