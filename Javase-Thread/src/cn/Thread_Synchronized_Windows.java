package cn;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 例子：创建三个窗口卖票，总票数为100张，使用实现runnable接口的方式
 *
 * 1.问题：卖票过程中，出现了重票、错票 --> 出现了线程安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未完成的过程中，其他线程参与进来，也来操作车票。
 * 3.如何解决：当一个线程a在操作ticketd的时候，其他线程不能参与进来，直到线程a操作完ticket时，其他
 *           线程才可以开始操作ticket。这种情况即使线程a出现了阻塞，也不能改变。
 *
 *@author 今天也要努力的小白
 *@date 2020/3/10 17:32
 */
public class Thread_Synchronized_Windows {
    public static void main(String[] args) {
        Windows1 windows1 = new Windows1();
        Thread thread1 = new Thread(windows1);
        Thread thread2 = new Thread(windows1);
        Thread thread3 = new Thread(windows1);
        thread1.start();
        thread2.start();
        thread3.start();


    }
}
class Windows1 implements Runnable
{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(100-i);
        }
    }
}

