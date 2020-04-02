/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

/**
 *@author 今天也要努力的小白
 *@creat 2020/4/2 18:00
 */

class Teacher{

    public void teach() {
        System.out.println("会教书");
    }

    public void eat() {
        System.out.println("Teacher在吃东西");
    }
}

class JavaTeacher extends Teacher{
    public void java() {
        System.out.println("会教java");
    }

    @Override
    public void eat() {
        System.out.println("javaTeacher在吃东西");
    }
}

public class FatherSonTest {
    @Test
    public void test() {
        JavaTeacher javaTeacher = new JavaTeacher();
        javaTeacher.java();
        javaTeacher.teach();

        Teacher teacher = new JavaTeacher();


        JavaTeacher javaTeacher1 = (JavaTeacher) teacher;

        javaTeacher1.java();

    }

}
