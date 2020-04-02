package IO流.练习;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 *@author 今天也要努力的小白
 *@creat 2020/3/26 9:52
 */
public class 比较节点流和缓冲流速度 {

    //节点流（文件流）
    public void copyFile(String srcPath, String destPath) {

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //1.指定要操作的文件
            File file1 = new File(srcPath);
            File file2 = new File(destPath);

            //2.指定流
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            //3.读入和写出操作
            byte[] buffer = new byte[1024];
            int len;//记录每次读取的字节的个数
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.关闭流资源
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testcopyFile() {

        long start = System.currentTimeMillis();

        String src = "C:\\Users\\Administrator\\Desktop\\01.avi";
        String dest = "C:\\Users\\Administrator\\Desktop\\03.avi";

        copyFile(src, dest);

        long end = System.currentTimeMillis();
        System.out.println("本次用时: " + (end - start) + "ms");//506ms

    }


    //缓冲流
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFileWithBuffered(){
        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\Administrator\\Desktop\\01.avi";
        String destPath = "C:\\Users\\Administrator\\Desktop\\03.avi";

        copyFileWithBuffered(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("本次用时: " + (end - start) + "ms");//506ms - 122ms
    }
}