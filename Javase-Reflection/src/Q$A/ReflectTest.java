package Q$A;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *@author 今天也要努力的小白
 *@creat 2020/3/31 19:53
 */
public class ReflectTest {

    @Test
    public void test() throws Exception{
        Class<PrivateTest> clazz = PrivateTest.class;

        Field name = clazz.getDeclaredField("name");

        PrivateTest privateTest = clazz.newInstance();

        name.setAccessible(true);

        name.set(privateTest,"hahakitty");

        Method getName = clazz.getDeclaredMethod("getName");
        Object o = getName.invoke(privateTest);
        System.out.println(o);

    }

}