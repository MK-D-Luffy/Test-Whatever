package cn.创建线程的两种方式;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 多线程的创建：方式一：继承Thread方法
 * 1.创建一个继承与Thread的子类
 * 2.重写父类Thread的run（）方法 -->将此线程进行的操作声明在run（）方法中
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start（）开启线程
 * <p>
 * 例子：遍历100以内的偶数
 *
 * @author 今天也要努力的小白
 * @date 2020/3/9 21:18
 */

class FirstWayTOCreatThread extends Thread {

    /**
     * 将此线程要进行的操作声明在run（）方法中！
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i = i + 2) {
            System.out.println(Thread.currentThread().getName()+":  "+i);
        }
    }
}
