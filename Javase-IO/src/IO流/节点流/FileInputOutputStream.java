    package IO流.节点流;
    /**
     * 今天也要元气满满啊！
     * 今天也要加油啊！
     * 道路,很远!脚步,更长!
     */

    import org.junit.jupiter.api.Test;

    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.IOException;

    /**
     * 测试FileInputStream和FileOutputStream的使用
     *
     * 结论：
     *  1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
     *  2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
     *
     *
     * @author 今天也要努力的小白
     * @creat 2020/3/26 8:26
     */
    public class FileInputOutputStream {

        @Test
        public void test() {
            FileInputStream fis = null;
            FileOutputStream fos = null;

            try {
                //1.指定要操作的文件
                File file1 = new File("C:\\Users\\Administrator\\Desktop\\01.avi");
                File file2 = new File("C:\\Users\\Administrator\\Desktop\\02.avi");

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
    }