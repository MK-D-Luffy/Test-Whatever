package Q$A;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *@author 今天也要努力的小白
 *@creat 2020/3/31 19:30
 */
public class NewInstanceTest {

    @Test
    public void test1 () throws Exception{

        Class<?> clazz = Class.forName("Q$A.Student");

        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
        Object o = declaredConstructor.newInstance();
        System.out.println(o);

        Constructor<?> declaredConstructor1 = clazz.getDeclaredConstructor(String.class, int.class);
        Object xiaohong = declaredConstructor1.newInstance("xiaohong", 12);
        System.out.println(xiaohong);


    }

    @Test
    public void test2() throws Exception{
        Class<Mytxt> clazz = Mytxt.class;

        Method myCreate = clazz.getDeclaredMethod("myCreate", String.class);

        myCreate.setAccessible(true);

        myCreate.invoke("myCreate", "myhello.txt");

    }

}
