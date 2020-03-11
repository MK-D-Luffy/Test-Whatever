package cn.线程的死锁问题;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 演示线程的死锁问题
 * <p>
 * 1.死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，
 * 都在等待对方放弃自己需要的同步资源，就形成了线程的死锁。
 * <p>
 * 2.说明：
 * 1）出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
 * 2）我们使用同步时要避免死锁。
 *
 * @author 今天也要努力的小白
 * @date 2020/3/11 14:01
 */
public class DeadLock {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread() {
            @Override
            public void run() {
                synchronized (s1) {
                    System.out.println("进入锁1");
                    try {
                        //Thread.sleep()->this.sleep()->sleep()
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2) {
                        System.out.println("进入锁1中的锁2");
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    System.out.println("进入锁2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1) {
                        System.out.println("进入锁2中的锁1");
                    }
                }
            }
        }).start();
    }
}
