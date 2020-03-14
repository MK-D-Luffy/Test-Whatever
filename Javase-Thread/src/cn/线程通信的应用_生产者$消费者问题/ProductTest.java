package cn.线程通信的应用_生产者$消费者问题;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 * <p>
 * 生产者(Producer)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 * <p>
 * 分析：
 * 1.是否为多线程问题？是，有消费者线程，生产者线程（店员持有的产品为共享数据）
 * 2.是否有共享数据？是，店员（或是说店员持有的产品）
 * 3.如何解决线程安全问题？三种同步机制：同步代码块，同步对象，Lock锁。
 * 4.是否涉及线程的通信？是，所以需要调用wait（）和notify（）方法。
 *
 * @author 今天也要努力的小白
 * @date 2020/3/11 22:12
 */
//生产者
class Producer implements Runnable {
    private Amount amount;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产产品...");
        /**（!!!）
         *while(true)的作用：使得生产和消费可以不断的进行下去，对两个线程来说，其中一个线程a被wait（）阻塞后，
         * 无法继续执行下面的代码,当在被另一个线程b唤醒后，如果没用while（true）循环，a线程会继续运行后面的代码。
         * 然后直接直接离开该线程（a线程），生产者和消费者只能有一次的交互（通信），不能达到一直交互的要求。
         */
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            amount.proAmount();
        }
    }

    public Producer(Amount amount) {
        this.amount = amount;
    }
}

//消费者
class Consumer implements Runnable {
    private Amount amount;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费产品...");
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            amount.conAmount();
        }
    }

    public Consumer(Amount amount) {

        this.amount = amount;
    }
}

//产品数量
class Amount {
    private static int amount = 0;

    public void proAmount() {

//        生成产品
        synchronized (this) {
            if (amount < 20) {
                amount++;
                System.out.println(Thread.currentThread().getName() + "开始生产第" + amount + "个");

                //一旦生产了，就唤醒消费者来消费。
                notify();
            } else {
                try {
                    //等待，如果生产太多超过20，就会先wait，等消费者消费到小于20个，在继续生产。
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void conAmount() {

//        消费产品
        synchronized (this) {
            if (amount > 0) {
                System.out.println(Thread.currentThread().getName() + "开始消费第" + amount + "个");
                amount--;

                //一旦消费了，就唤醒生产者去生产
                notify();
            } else {
                try {
                    //等待，如果消费的过快，导致数量等于0了，进入等待，等待生产者生产了以后在唤醒。
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getAmount() {
        return amount;
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Amount amount = new Amount();
        Producer producer = new Producer(amount);
        Consumer consumer = new Consumer(amount);

        Thread prothread = new Thread(producer, "生产者");
        Thread conthread = new Thread(consumer, "消费者");
        prothread.start();
        conthread.start();
    }
}