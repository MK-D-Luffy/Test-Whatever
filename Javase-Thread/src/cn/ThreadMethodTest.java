package cn;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 测试线程中的常用方法：
 * 1.start（）:启动线程，调用当前线程run（）方法。
 * 2.run（）方法:通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明再此方法中。
 * 3.currentThread（）:静态方法，返回执行当前代码的线程。
 * 4.getName()方法：获取当前线程的名字。
 * 5.setName()方法：设置当前线程的名字。(也可以重写构造器来直接外部设置线程名)
 * 6.yield()方法：释放CPU的执行权限。（也叫让出线程）
 * 7.join()方法： 在线程a调用线程b的时候，线程b中使用join方法，可以直接阻塞其他线程，
 * 让本线程先行，在本线程结束后，才结束阻塞状态。（也叫加入线程）
 * 8.stop（）方法：已过时,强制结束当前线程。
 * 9.sleep（long ms）方法：让当前线程睡眠指定的ms毫秒时间。在指定的ms毫秒时间内，当前线程是阻塞状态。
 * sleep()方法是静态方法static   |   调用方式：Thread.sleep()。
 * 10.isAlive（）方法：判断当前线程是否存活。
 *
 *
 * 线程的优先级：
 * 1.
 * MAX_PRIORITY：10
 * MIN _PRIORITY：1
 * NORM_PRIORITY：5  -->默认优先级
 * 2.如何获取和设置当前线程的优先级：
 *   getPriority():获取线程的优先级
 *   setPriority(int p):设置线程的优先级
 *
 *   说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率的情况下
 *   被执行。并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行。
 *
 *
 * @author 今天也要努力的小白
 * @date 2020/3/10 8:22
 */
class ThreadDemo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            //让出线程，在i%49=0时，将释放CPU的执行权限，在由线程池中的所有线程去抢夺资源
//            if (i % 49 == 0) {
//                yield();
//            }
        }

    }

    public ThreadDemo() {
    }

    //重写构造器来设置线程的名字
    public ThreadDemo(String name) {
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threaddemo = new ThreadDemo();
        threaddemo.setName("线程一");
        threaddemo.start();

        //用setName（）方法设置线程的名字
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            //当主线程运行到i=50时，加ThreadDemo线程加入，优先运行
//            if (i == 50) {
//                try {
//                    threaddemo.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

            //当i=50时，让当前线程（主线程）休眠1s，其他线程不会被影响
            if (i == 50) {
                Thread.sleep(1000);
            }
            System.out.println(threaddemo.isAlive());

        }
    }
}
