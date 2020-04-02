package 动态代理_$;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

/**
 * 静态代理举例
 *
 * 特点: 代理类和被代理类在编译期间就确定下来了。
 *
 *@author 今天也要努力的小白
 *@creat 2020/4/2 15:22
 */
interface Produce{
   public void produce();
}

//被代理类
class NikeProduce implements Produce{
    @Override
    public void produce() {
        System.out.println("生产Nike球鞋");
    }
}


//代理类
class ProxyProduce implements Produce{

    private Produce proxy;

    public ProxyProduce(Produce proxy) {
        this.proxy = proxy;
    }

    @Override
    public void produce() {

        System.out.println("代理工厂做一些准备工作");

        proxy.produce();

        System.out.println("代理工厂做一些后续的收尾工作");
    }
}


public class StaticProxyTest {

    @Test
    public void test() {

        //代理类的对象来调用，代理类来生成球鞋

        ProxyProduce proxyProduce = new ProxyProduce(new NikeProduce());
        proxyProduce.produce();

    }

}
