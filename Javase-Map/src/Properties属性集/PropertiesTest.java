package Properties属性集; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties:常用来处理配置文件。key和value都是String类型。
 * pro.load(new FileInputStream)：加载流对应的文件。
 * 将pro变为Map<key,value>;
 * value = pros.getProperty(key);
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/22 8:32
 */
public class PropertiesTest {
    @Test
    public void test() {
        //Properties:常用来处理配置文件。key和value都是String类型
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();

            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);//加载流对应的文件

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name = " + name + ", password = " + password);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
