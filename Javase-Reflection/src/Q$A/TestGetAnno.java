package Q$A;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 *@author 今天也要努力的小白
 *@creat 2020/3/31 19:47
 */
public class TestGetAnno {

    @Test
    public void test() throws NoSuchMethodException {

        Class<? extends Student> clazz = new Student().getClass();
        Method toString = clazz.getDeclaredMethod("toString");

        //获取方法的注解，只能获取RUNTIME修饰的注解
        Annotation[] declaredAnnotations = toString.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }

    }
    
}
