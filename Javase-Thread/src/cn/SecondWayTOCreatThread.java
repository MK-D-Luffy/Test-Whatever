package cn;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 多线程的创建：方式二：实现Runnable接口
 * 1.创建一个实现了Runnable接口的实现类。
 * 2.实现类去实现Runnable接口中的抽象方法：run（）
 * 3.创建实现类的实例对象。
 * 4.将此对象作为参数target传入到Thread构造器中，创建Thread类的对象。
 * 5.通过Thread类的对象来调用start（）方法。
 *
 * @author 今天也要努力的小白
 * @date 2020/3/10 11:19
 */

//1.创建一个实现Runnable接口的对象
class SecondWayTOCreatThread implements Runnable {
    //2.实现抽象类的run（）方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
