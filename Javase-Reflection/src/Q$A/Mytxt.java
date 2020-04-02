package Q$A;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import java.io.File;
import java.io.IOException;

/**
 * @author 今天也要努力的小白
 * @creat 2020/3/31 19:35
 */
public class Mytxt {

    public static boolean myCreate(String fileName) throws IOException {
        System.out.println("创建了一个文件");
        return new File(fileName).createNewFile();
    }

}
