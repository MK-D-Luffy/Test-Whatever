/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * jdk 8之前的日期时间的API测试(3)
 *
 * 3.SimpleDateFormat
 *      1)格式化:format(Date)方法      （Date ---> String):
 *          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH-mm-ss SSS");
 *          String format = sdf.format(date);
 *      2)解析日期：parse(String)方法: （String ---> Date)
 *          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
 *          Date parse = sdf1.parse("2020-08-23");
 *
 *          解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),否则，抛异常。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/15 10:34
 */
public class SimpleDateFormatTest {
    @Test
    public void test1() throws ParseException {
        //简单日期格式化
        // 1.创建日期实例对象
        Date date = new Date();
        //2.创建简单日期对象的日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH-mm-ss SSS");
        //3.调用format（）方法进行格式化
        String format = sdf.format(date);
        System.out.println(format);


        /*
        练习：将字符串“2020-08-23”转换为java.sql.Date
                    (parse)    （构造器)
              String -----> Date -----> sql.Date
         */

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        //解析：parse（），将一个时间格式的字符串转换为Date
        Date parse = sdf1.parse("2020-08-23");
        java.sql.Date date1 = new java.sql.Date(parse.getTime());
        System.out.println(date1);

    }
}