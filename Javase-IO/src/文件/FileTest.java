package 文件;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import java.io.File;

/**
 * File类的使用
 *
 * 1. File类的一个对象，代表一个文件或一个文件目录(俗称：文件夹)
 *    File是用来表示文件和文件夹的类。
 * 2. File类声明在java.io包下
 * 3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *    并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
 *
 *    说明：File本身的对文件的一些属性的操作用File类。
 *         涉及到File内容的操作，如：读写数据，就要用到IO流。
 *
 * 4. 后续File类的对象常会作为参数传递到流的构造器中，作为读取或写入的"终点".
 *    通过IO流将File文件的内容与内存相关联。
 *
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/24 9:53
 */
public class FileTest {
    /**
     * 1.如何创建File类的实例
     *   File(String filePath)
     *   File(String parentPath,String childPath)
     *   File(File parentFile,String childPath)
     *
     * 2.路径:
     *  相对路径：相较于某个路径下，指明的路径。
     *  绝对路径：包含盘符在内的文件或文件目录的路径
     *
     * 3.路径分隔符
     *  windows和DOS:\\
     *  unix:/
     */

    @Test
    public void test1() {

        //构造器1：File(String filePath)
        File file = new File("HelloWorld.txt");//在此module下的相对路径
        File file1 = new File("C:\\Users\\Administrator\\Desktop\\Hello.txt");//绝对路径

        //构造器2：File(String parentPath,String childPath)
        File file2 = new File("C:\\Users\\Administrator", "Desktop");

        //构造器3：File(File parentFile,String childPath)
        File file3 = new File(file2, "Hello.txt");

    }
}
