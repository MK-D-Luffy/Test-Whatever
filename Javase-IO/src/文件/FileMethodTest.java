package 文件;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的常用方法:
 * 获取：
 *  String getAbsolutePath()：获取绝对路径
 *  String getPath()：获取路径
 *  String getName()：获取名称
 *  String getParent()：获取上层文件目录路径。若无，返回null
 *  long length()：获取文件长度（即：字节数）。不能获取文件夹的大小。
 *  long lastModified()：获取最后一次的修改时间，毫秒值
 *
 * 获取文件目录下的所有文件或文件夹：
 *  String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
 *  File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
 *
 * 重命名+转移：
 *  boolean renameTo(File dest):把文件重命名并转移到指定的文件路径。
 *  比如：file1.renameTo(file2)为例：
 *  要想保证返回true,需要file1在硬盘中是存在的，且file2在硬盘中是不存在的。
 *
 * 判断功能：
 *  boolean isDirectory()：判断是否是文件目录
 *  boolean isFile()：判断是否是文件
 *  boolean exists()：判断是否存在
 *  boolean canRead()：判断是否可读
 *  boolean canWrite()：判断是否可写
 *  boolean isHidden()：判断是否隐藏
 *
 * 创建与删除功能：
 *  创建硬盘中对应的文件或文件目录
 *   boolean createNewFile()：创建文件。若文件存在，则不创建，返回false
 *   boolean mkdir()：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
 *   boolean mkdirs()：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建
 *
 *  删除磁盘中的文件或文件目录
 *   boolean delete()：删除文件或者文件夹。
 *   删除注意事项：1)对文件夹来说，要想删除成功，其目录下不能有子目录或文件。
 *                2)Java中的删除不走回收站。
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/24 10:42
 */
public class FileMethodTest {
    //获取文件基本信息
    @Test
    public void test1(){
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\develop\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

    }

    //获取指定文件路径下所有文件或文件夹的名称或对象.
    @Test
    public void test2(){
        File file = new File("D:\\develop");

        //获取路径下所有文件的名称：String[] list()
        String[] list = file.list();
        for(String s : list){
            System.out.println(s);
        }

        System.out.println();

        //获取路径下所有文件的File对象：File[] listFiles()
        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }
    }

    //重命名+转移：
    //boolean renameTo(File dest):把文件重命名并转移到指定的文件路径。
    @Test
    public void test3(){
        File file1 = new File("hello.txt"); //要存在(路径要正确!)
        File file2 = new File("D:\\io\\hi.txt");//不能存在

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);

    }

    //判断功能
    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        file1 = new File("hello1.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

    }

    //创建和删除文件
    @Test
    public void test5() throws IOException {
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            //文件的创建,如果文件已存在，则创建失败。
            file1.createNewFile();

        }else{//文件存在
            file1.delete();
        }
    }

    //创建文件夹
    @Test
    public void test6(){
        //文件目录的创建：
        //1)创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
        File file1 = new File("d:\\io\\io1\\io2");
        boolean mkdir = file1.mkdir();

        //2)创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建。
        File file2 = new File("d:\\io\\io1\\io4");
        boolean mkdir1 = file2.mkdirs();

        //要想删除成功，io1文件目录下不能有子目录或文件
        File file3 = new File("D:\\io\\io1");
        System.out.println(file3.delete());
    }
}