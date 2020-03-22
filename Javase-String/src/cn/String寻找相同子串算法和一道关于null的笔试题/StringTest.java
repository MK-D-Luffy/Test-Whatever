package cn.String寻找相同子串算法和一道关于null的笔试题;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

/**
 * String算法：寻找两个字符串的最大相同子串，并输出。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/15 8:51
 */
public class StringTest {

    @Test
    public void test1() {
        String s1 = "asjkddfjkuwksxc";
        String s2 = "kddjwxksx";
        int flag = 0;

        for (int i = 0; i <= s2.length(); i++) {
            for (int x = 0, y = s2.length() - i; y <= s2.length(); x++, y++) {
                if (s1.contains(s2.substring(x, y))) {
                    System.out.println(s2.substring(x,y));
                    flag=1;
                }
            }
            if (flag==1) {
                break;
            }
        }
    }
}