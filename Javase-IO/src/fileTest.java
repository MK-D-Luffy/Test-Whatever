/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *@author 今天也要努力的小白
 *@creat 2020/4/1 21:15
 */
public class fileTest {

    public static void main(String[] args) {

        Writer fileWriter = null;
        try {
            fileWriter = new FileWriter(new File("test.txt"));

            fileWriter.write("helloworld");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileWriter!=null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}