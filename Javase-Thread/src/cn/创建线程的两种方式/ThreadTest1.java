package cn.创建线程的两种方式;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * @author 今天也要努力的小白
 * @date 2020/3/10 11:30
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        SecondWayTOCreatThread secondWayTOCreatThread = new SecondWayTOCreatThread();

        //4.将此对象作为参数传递到Thread类的构造器，创建Thread类的对象
        Thread thread = new Thread(secondWayTOCreatThread, "线程1");

        //5.通过Thread类的对象调用start（）：start()方法的作用：
        // ① 启动线程  ② 调用当前线程的run（）-->调用了Runnable类型的target的run（）
        thread.start();
    }
}
