package cn.用同步的方式解决窗口卖票的不安全性;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 使用同步方法的方式解决实现Runnable接口的线程安全问题
 *
 *
 * 关于同步方法的总结：
 * 1.同步方法仍然涉及到同步监视器，只是不需要我们显示的声明。
 * 2.非静态的同步方法，同步监视器是：this
 *   静态的同步方法，同步监视器是：当前类本身
 *
 * @author 今天也要努力的小白
 * @date 2020/3/11 9:49
 */
public class Window_Test_imRunnable {
    public static void main(String[] args) {
        WindowTest windowTest = new WindowTest();

        Thread thread1 = new Thread(windowTest);
        Thread thread2 = new Thread(windowTest);
        Thread thread3 = new Thread(windowTest);

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class WindowTest implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            method();
        }
    }

      private synchronized void method() {//同步监视器 对象的this->windowTest
        if (ticket > 0) {
            System.out.println(ticket);
        }
        ticket--;
    }
}