package 创建运行时类的对象_$;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import 反射概述.Person;

import java.util.Scanner;

/**
 * 通过反射创建运行时类的对象
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/31 7:54
 */
public class NewInstanceTest {

    @Test
    public void testInstance() throws IllegalAccessException, InstantiationException {

        Class<Person> clazz = Person.class;

        /**
         * newInstance(): 调用此方法，创建对应运行时类的对象(!!!)
         * 要求: 1)要想使用此方法访问，运行时类必须提供空参构造器。
         *      2)并且空参构造器的访问权限得够。通常设置为public。
         *
         * 在javabean中要求提供一个public的空参构造器
         *  原因: 1)便于通过反射去创建运行时类的对象
         *       2)便于子类继承此运行时类，并默认调用super()时，保证父类有此构造器
         *
         */

        Person person = clazz.newInstance();
        System.out.println(person);

    }

    //反射动态性的一个体现
    @Test
    public void testReflection() {

        String classPath = "";
      while (true){
            switch (new Scanner(System.in).nextInt()) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "反射概述.Person";
                    break;
                case 2:
                    classPath = "java.lang.String";
                    break;
                default:
                    break;
            }
            try {
                System.out.println(newInstance(classPath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object newInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

}
