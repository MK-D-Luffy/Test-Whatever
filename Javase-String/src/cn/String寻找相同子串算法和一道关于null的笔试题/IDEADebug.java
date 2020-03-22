package cn.String寻找相同子串算法和一道关于null的笔试题;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

/**
 * 一道关于null的笔试题
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/15 8:27
 */
public class IDEADebug {
    @Test
    public void testStringBuffer() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//查看底层有appendNull()方法处理null，可以直接生成“null”字符加入

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常NullPointerException
        System.out.println(sb1);//
    }
}