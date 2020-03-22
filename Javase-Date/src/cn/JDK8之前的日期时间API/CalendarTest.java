/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8之前的日期时间的API测试
 * <p>
 * 4.Calendar日历类(抽象类）的使用
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/15 12:38
 */

public class CalendarTest {
    @Test
    public void test1() throws ParseException {
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象(不常用)
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //set()
        //calendar可变性(属性皆可变)
        calendar.set(Calendar.DAY_OF_MONTH, 12);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //add()（在原有属性天数上增加）
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}