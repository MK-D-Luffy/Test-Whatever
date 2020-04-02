package 动态代理_$;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 * <p>
 * 要想实现动态代理，需要解决的问题？
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
 * 问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法。
 *
 * @author 今天也要努力的小白
 * @creat 2020/4/2 16:08
 */
//某一个被代理类实现的接口(方法)
interface Human {
    public void eat(String food);
}

//某一个被代理类
class Superman implements Human {

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }

}

//解决代理类调用被代理的同名方法
class MyInvocationHandler implements InvocationHandler {

    //被代理类的对象
    private Object obj;

    public void bind (Object obj) {
        this.obj = obj;
    }

    //当我们通过代理类的对象调用方法a时，就会自动的调用如下的方法: invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用代理类的方法时会自动转到调用被代理类方法 (代理模式!)
        //调用的是 Method method 中的 invoke( Object obj , Object...args )
        Object returnValue = method.invoke(obj, args);

        //返回调用的被代理类方法的返回值
        return returnValue;
    }
}

//生成代理类
class ProxyFactory {

    //通过调用此方法，生成并返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj) {//obj: 被代理对象

        //解决代理类调用被代理的同名方法
        MyInvocationHandler handler = new MyInvocationHandler();

        //指定被代理类
        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);

    }

}

public class ProxyTest {

    @Test
    public void test() {
        Superman superman = new Superman();

        //proxyInstance: 代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superman);

        proxyInstance.eat("老干妈");

    }

}