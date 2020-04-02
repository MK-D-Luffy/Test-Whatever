package IO流.练习;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 文件的加密与解密
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/26 10:37
 */
public class 文件的加密与解密操作 {
    @Test
    public void test() {
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        try {
            bi = new BufferedInputStream(new FileInputStream("01.png"));
            bo = new BufferedOutputStream(new FileOutputStream("01serect.png"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bi.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                bo.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bi != null) {
                    bi.close();
                }
                if (bo != null) {
                    bo.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //图片的解密
    @Test
    public void test2() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("01serect.png");
            fos = new FileOutputStream("02.png");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //字节数组进行修改
                //错误的
                // for(byte b : buffer){
                //   b = (byte) (b ^ 5);
                // }
                //正确的
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}