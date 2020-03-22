package 方式二enum关键字定义枚举类;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 * 用enum关键字创建的枚举类可以直接调用父类的对象
 * <p>
 * Enum类中的常用方法：
 *      values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *      valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。
 *                           如果不是，会有运行时异常：IllegalArgumentException。
 *      toString()：返回当前枚举类对象常量的名称。
 *
 * 使用enum关键字定义的枚举类实现接口的情况：
 *      情况一：实现接口，在enum类中实现抽象方法。
 *      情况二：让枚举类的对象分别实现接口中的抽象方法。(!!!)
 * @author 今天也要努力的小白
 * @creat 2020/3/17 21:51
 */
//使用enum关键字定义枚举类
public class enumTest {
    @Test
    public void test1() {
        //values():返回所有的枚举类对象构成的数组
        Season[] values = Season.values();
        System.out.println(Arrays.toString(values));

        //valueOf(String str):返回枚举类中对象名是str的对象。
        Season spring = Season.valueOf("SPRING");
        System.out.println(spring);

        //toString():返回枚举类对象的名称
        System.out.println(Season.SPRING.toString());//返回SPRING
    }
}
//用enum关键字创造枚举类
enum Season {//implements Info
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "凛冬将至");

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器,并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //4.其他诉求重写toString()、getter()
}
interface Info{
    public void show();
}