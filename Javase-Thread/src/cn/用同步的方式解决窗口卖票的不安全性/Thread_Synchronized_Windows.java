package cn.用同步的方式解决窗口卖票的不安全性;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 例子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
 * <p>
 * 1.问题：卖票过程中，出现了重票、错票 --> 出现了线程安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未完成的过程中，其他线程参与进来，也来操作车票。
 * 3.如何解决：当一个线程a在操作ticketd的时候，其他线程不能参与进来，直到线程a操作完ticket时，其他
 *            线程才可以开始操作ticket。这种情况即使线程a出现了阻塞，也不能改变。
 * ----------------------------------------------------------------------------------
 * 4.在java中，我们通过同步机制，来解决线程的安全问题。
 *
 * 方式一：同步代码块
 *
 *  synchronized（同步监视器）{
 *  //需要被同步的代码
 *
 *  }
 *  说明: 1.操作共享数据的代码，即为需要被同步的代码  ---> 不能包含代码多了(!!!)，也不能包含少了。
 *       2.共享数据：多个线程共同操作的数据变量，比如：ticket就是共享数据
 *       3.同步监视器：俗称锁。任何一个类的对象，都可以充当锁。
 *             要求：多个线程必须要共用同一把锁。
 *
 *        补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器
 *
 * ----------------------------------------------------------------------------------
 *  方式二：同步方法
 *
 *      如果操作共享数据的代码完整的声明在一个方法中，我们不妨将该方法声明成同步的。
 *
 *      关于同步方法的总结：
 *          1.同步方法仍然涉及到同步监视器，只是不需要我们显示的声明。
 *          2.非静态的同步方法，同步监视器是：this
 *            静态的同步方法，同步监视器是：当前类本身
 *
 *-----------------------------------------------------------------------------------
 *
 *  5.同步操作的方式：解决了线程安全的问题 --- 好处
 *  操作同步代码时，只能有一个线程参与，其他线程就等待。相当于是一个单线程的过程，效率低。     --- 局限性
 *
 * @author 今天也要努力的小白
 * @date 2020/3/10 17:32
 */
public class Thread_Synchronized_Windows {
    public static void main(String[] args) {
        //采用实现接口的方式实现同步代码块
        Windows1 windows1 = new Windows1();

        Thread thread1 = new Thread(windows1);
        Thread thread2 = new Thread(windows1);
        Thread thread3 = new Thread(windows1);

        thread1.start();
        thread2.start();
        thread3.start();

        //采用继承类的方式实现同步代码块
        Window2 window21 = new Window2();
        Window2 window22 = new Window2();
        Window2 window23 = new Window2();
        window21.start();
        window22.start();
        window23.start();
    }
}

class Windows1 implements Runnable {
    Object obj = new Object();
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {//也可以this-->window1这个对象
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                } else {
                    break;
                }
                ticket--;
            }
        }
    }
}

class Window2 extends Thread {
    private static int ticket = 100;
    private static String str = "";

    @Override
    public void run() {
        while (true) {
            synchronized (str) {//也可以用类对象（Windows2.class）
                if (ticket >0) {
                    System.out.println(ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}
