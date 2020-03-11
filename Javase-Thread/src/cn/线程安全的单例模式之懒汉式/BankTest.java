package cn.线程安全的单例模式之懒汉式;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author 今天也要努力的小白
 * @date 2020/3/11 11:12
 */
public class BankTest {
    public static void main(String[] args) {

    }
}

//单例模式之懒汉式线程安全升级
class Bank {
    //1.私有化构造器
    private Bank() {
    }

    //2.在内部创建一个实例对象
    private static Bank instance = null;

    public static Bank getInstance() {
        //方式一：效率略差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//        }

        //方式二：效率更高
        if (instance == null) {

            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }

        return instance;
    }
}

//------------------------------------------------------------------
//单例模式之饿汉式回顾
class Bank1 {
    private Bank1() {
    }

    private static Bank1 instance1 = new Bank1();

    public static Bank1 getInstance() {
        return instance1;
    }

}