/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * DateTimeFormatter:格式化或解析日期、时间
 * 类似于SimpleDateFormat
 *
 * 重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
 * @author 今天也要努力的小白
 * @creat 2020/3/15 15:13
 */
public class DateTimeFormatterTest {
    @Test
    public void test3() {

//      重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd HH:mm:ss”)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //格式化
        String str = formatter.format(LocalDateTime.now());
        System.out.println(str);//2020-03-15 16:40:15

        //解析
        TemporalAccessor accessor = formatter.parse("2020-03-15 16:40:15");
        System.out.println(accessor);



//      方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter1.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);//2020-03-15T16:35:09.5585918

        //解析：字符串 -->日期
        TemporalAccessor parse = formatter1.parse("2019-02-18T15:42:18.797");
        System.out.println(parse);


//      方式二：
//      本地化相关的格式。如：ofLocalizedDateTime()
//      FormatStyle.MEDIUM / FormatStyle.SHORT ( FormatStyle.LONG❌):适用于LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        //格式化（LocalDateTime ---> String）
        String str2 = dateTimeFormatter.format(localDateTime);
        System.out.println(str2);

//      另外的格式。如：ofLocalizedDate()
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String format = dateTimeFormatter1.format(LocalDate.now());
        System.out.println(format);

//        另外的格式。如：ofLocalizedTime()
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        String format1 = dateTimeFormatter2.format(LocalTime.now());
        System.out.println(format1);

    }
}
