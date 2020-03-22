package 方式一自定义枚举类;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

/**
 * 一、枚举类的使用
 * 1.枚举类的理解：我们把只有有限个、确定个对象的类称为枚举类。（确定个：表常量final）（有限个：表常量的个数）
 * 2.当需要定义一组常量（只能初始化，无法在后续改变其值，用final修饰）时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
 * <p>
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0，可以使用enum关键字定义枚举类
 * <p>
 * 三、Enum类中的常用方法：
 *      values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *      valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
 *      toString()：返回当前枚举类对象常量的名称。
 * <p>
 * 四、使用enum关键字定义的枚举类实现接口的情况
 *  情况一：实现接口，在enum类中实现抽象方法
 *  情况二：让枚举类的对象分别实现接口中的抽象方法
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/17 18:46
 */
public class SeasonTest {
    @Test
    public void testEnum() {
        System.out.println(Season.Spring);
        System.out.println(Season.Spring.getSeasonName());
        System.out.println(Season.Spring.getSeasonDesc());
    }
}
//自定义枚举类
class Season {
    //1.声明Season对象的属性：private（封装）,final(表常量，后续无法改变)
    //因为Season对象本身也是常量，无法改变；所以Season对象的属性也是常量（用final修饰），无法改变。
    private final String seasonName;
    private final String seasonDesc;

    //因为类的对象是有限确定个，所以外部无法通过new+构造器来新建实例对象，所以要将构造器私有化。
    //2.私有化构造器
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //public(构造器被私有化，不能通过直接new+构造器新建对象，又因为对象是常量，能被外部所调用，所以定义为public),
    //static(定义为静态，也叫类对象，可以由类直接调用),final（表常量，不能在被改变了，枚举类特性）
    //3.定义Season枚举类的常量对象（public static final），确定该枚举类所要用的一组对象
    public static final Season Spring = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "凛冬将至");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}