package 文件.File类的课后练习;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * 课后练习1：创建和删除某个路径下的文件或文件夹。
 * 课后练习2：判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称。
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/24 14:45
 */
public class FileExercise1 {
    @Test
    public void test1() throws IOException {
        File file = new File("hello.txt");
        //创建文件
        boolean newFile = file.createNewFile();
        System.out.println(newFile);
        //删除文件
        boolean delete = file.delete();
        System.out.println(delete);
    }

    //练习二：输出后缀带有jpg的文件
    //方法一
    @Test
    public void test2() {
        File file = new File("C:\\Users\\Administrator\\IdeaProjects\\TestGithub");
        String[] list = file.list();
        for (String s : list) {
            if(s.endsWith(".jpg")){
                System.out.println(s);
            }
        }

        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file.getName().endsWith(".jpg")){
                System.out.println(files);
            }
        }
    }

    /**
     * 方法二：使用文件过滤器直接过滤文件
     *  File类提供了两个文件过滤器方法
     * 	String[] list(FilenameFilter filter)
     * 	File[] listFiles(FileFilter filter)
     */
    @Test
    public void test3() {
        File file = new File("C:\\Users\\Administrator\\IdeaProjects\\TestGithub");
        String[] files = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg");
            }
        });
        for (String s : files) {
            System.out.println(s);
        }
    }
}