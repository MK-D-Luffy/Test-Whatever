package cn.JDK8之后新的日期时间API;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Instant的使用
 * 类似于 java.util.Date类
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/15 15:12
 */
public class InstantTest {
    @Test
    public void testInstant() {
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例  --->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(13215664621113L);
        System.out.println(instant1);
        OffsetDateTime offsetDateTime1 = instant1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime1);
    }
}
