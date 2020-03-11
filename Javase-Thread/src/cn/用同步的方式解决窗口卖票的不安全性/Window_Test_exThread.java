package cn.用同步的方式解决窗口卖票的不安全性;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 使用同步方法的方式解决继承Thread类的线程安全问题
 *
 * @author 今天也要努力的小白
 * @date 2020/3/11 9:49
 */
public class Window_Test_exThread {
    public static void main(String[] args) {

        WindowTest1 windowTest1_1 = new WindowTest1();
        WindowTest1 windowTest1_2 = new WindowTest1();
        WindowTest1 windowTest1_3 = new WindowTest1();

        windowTest1_1.start();
        windowTest1_2.start();
        windowTest1_3.start();
    }

}

class WindowTest1 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            method();
        }
    }

    private static synchronized void method() {//同步监视器 :类的this，WindowTest1.class（类对象，唯一的！）
//      private synchronized void method() {//同步监视器 对象的this->windowTest1_1、2、3（不是唯一！）
        if (ticket > 0) {
            System.out.println(ticket);
        }
        ticket--;
    }
}