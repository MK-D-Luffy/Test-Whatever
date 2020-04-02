package Q$A;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 今天也要努力的小白
 * @creat 2020/3/31 20:04
 */
public class FileTest {
    @Test
    public void test() throws IOException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> clazz = Class.forName("Q$A.File");

        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);

            if (declaredConstructor.getParameterCount() == 1) {
                declaredConstructor.newInstance("myhello.txt");
            }
        }
    }
}

class File {

    public File() {
    }

    public File(String name) {
        try {
            new java.io.File(name).createNewFile();
            System.out.println("文件创建完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}