package cn.线程通信;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 线程通信的例子：使用两个线程打印1-100.线程1，线程2，交替打印
 * <p>
 * 涉及到的三个方法：
 * wait（）：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。(使其他线程可以进入)
 * notify（）：一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll（）：一旦执行此方法，就会唤醒所有被wait的线程。
 * <p>
 * 说明：
 * 1.wait（），notify（）， notifyAll（）三个方法必须使用在同步代码块或同步方法中。
 * 2.wait（），notify（），notifyAll（）三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 *      否则会出现IllegalMonitorStateException异常。
 * 3.wait（），notify（），notifyAll（）三个方法是定义在java.lang.Object类中。
 *
 * 面试题：sleep（）和wait（）的异同？
 * 1.相同点：一旦执行方法，都可以使当前的线程进入阻塞。
 * 2.不同点: 1）两个方法声明的位置不同：Thread类中声明sleep（），Object类中声明的wait（）。
 *          2)调用的要求不同：sleep（）是在任何场景下都能调用。wait（）方法只能在同步代码块或同步方法中调用。
 *          3)关于是否释放同步监视器：如果两个方法都使用在同步代码块和同步方法中，sleep（）不会释放锁，wait会释放锁。
 *
 *
 *
 * @author 今天也要努力的小白
 * @date 2020/3/11 17:29
 */
class Number implements Runnable {
    private int number = 1;
    private Object obj =new Object();
    @Override
    public void run() {

        while (true) {
            synchronized (obj) {
                obj.notify();
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                } else {
                    break;
                }
                try {
                    //使得调用如下wait（）方法的线程进入阻塞状态
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


public class Thread_Communication {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number, "线程1");
        Thread thread2 = new Thread(number, "线程2");

        thread1.start();
        thread2.start();

    }
}
