package cn;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 * <p>
 * 1.是不是一个多线程问题？是，两个储户线程要操作共享的同一个账户。
 * 2.是否有共享数据？有，账户（或账户余额）
 * 3.存不存在线程安全问题？存在
 * 4.需要考虑如何解决：
 *   对操作共享数据的代码实现线程安全（即加锁的操作即可）。
 *
 * 实现线程安全的三种方式（回顾）：
 * Lock锁：
 * 1.实例化lock接口的实现类ReentrantLock
 * 2.在需要操作共享数据的地方加上try/finally，
 * 3.为共享数据语句实现加锁，解锁，即达成线程安全。
 *
 * synchronized实现同步代码块：
 * synchronized（同步监视器，也叫锁）{
 *    //操作共享数据的语句（需要加上线程安全的语句）
 * }
 *
 * synchronized实现同步方法：
 *
 * synchronized加在方法上的默认同步监视器就是this：
 * 1.对于继承Thread类来说，是每个对象，所以要加上static，使其变成这些对象共享的数据。
 * 2.对于实现Runnable接口来说，是只有一个对象的。因为只创建了一个Runnable实例对象，
 * 然后再用改对象去创建多个线程的，所以不用加static也可。
 *
 * @author 今天也要努力的小白
 * @date 2020/3/11 16:23
 */
class Account {
    private int money = 0;
    //实例化ReentrantLock对象
    private ReentrantLock lock =new ReentrantLock();
    //存钱
    public void saveMoney(int amount) {

        money += amount;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":存钱 " + money);
    }
}

class Customer extends Thread {
    Account account;
    private static ReentrantLock lock =new ReentrantLock();

    public Customer(Account account) {
        this.account = account;
    }

    @SuppressWarnings ("AlibabaLockShouldWithTryFinally")
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                lock.lock();
                account.saveMoney(1000);
            } finally {
                lock.unlock();
            }
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);
        customer1.setName("A账户");
        customer2.setName("B账户");
        customer1.start();
        customer2.start();

    }
}
