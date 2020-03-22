/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

/**
 * 注解的使用
 * <p>
 * 1. 理解Annotation:
 * ① jdk 5.0 新增的功能
 * ② Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。
 *   通过使用 Annotation,程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 * ③ 在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android
 *   中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗
 *   代码和XML配置等。
 * <p>
 *
 * 2. Annocation的使用示例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)：
 *      @Override: 限定重写父类方法, 该注解只能用于方法。
 *      @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择。
 *      @SuppressWarnings: 抑制编译器警告。
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 * <p>
 *
 * 3.自定义注解
 *      ①定义Annotation类型（即注解类）时必须要有@interface关键字
 *      ②定义内部成员，通常用value表示
 *      ③可以用default指定成员的默认值
 *      ④如果自定义注释没有成员，就是一个标识作用
 *
 *      如果注解有成员在使用时需要指明成员变量的值
 *      自定义注解必须配上注解的信息处理流程(使用反射)才有意义
 *      自定义注解通常都会指定这两个元注解: Retention、Target（!!!）
 * <p>
 *
 * 4.jdk提供的4种元注解：
 *  元数据(@interface)：修饰数据的数据称为元数据
 *  元注解：修饰注解的注解称为元注解
 *  1)@Retention：指定修饰符的生命周期:SOURCE\CLASS(默认行为)\RUNTIME
 *    只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 *    例：@Retention (RetentionPolicy.RUNTIME)
 *
 *  2)@Target:用于指定被修饰的Annotation能用于修饰哪些元素。(简单的说就是指定修饰的范围)
 *  例：@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER...})
 *
 *  **********出现频率较低（了解）**********
 *  3)@Documented:表示所修饰的注解在被javadoc解析时，将会被javadoc工具提取成文档。
 *  修饰的注解会被保留下来。默认情况下，javadoc是不包括注解的。
 *  定义为Documented的注解必须设置Retention值为RUNTIME
 *
 *  4)@Inherited:被它修饰的annotation将具有继承性。如果某个类使用了
 *  被 @Inherited 修饰的 Annotation, 则其子类将自动具有该注解。
 *  比如：如果把标有@Inherited注解的自定义的注解标注在类级别上，
 *         其子类则可以继承父类的注解。
 * <p>
 *
 * 5.通过反射来获取注解信息
 * <p>
 *
 * 6.jdk8中注解的新特性:（可重复注解，类型注解）：
 *  6.1 可重复注解:① 在 @Annotation 上声明@Repeatable(Annotations.class)，
 *                  Annotations.class（是将@Annotation和@Annotations关联在一起）
 *                  @Annotations中定义的是 Annotation[] value()
 *                ② @Annotation 的@Target（表作用的的类型）和@Retention(表生命周期相同)
 *                  等元注解(如@Inherited)要与@Annotations相同。
 *  6.2 类型注解
 *      1)ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（用于声明如:<@annotation T>泛型声明）。
 *      2)ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。(用于类型如: int num=(@annotation int)"12")
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/18 14:50
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
@interface  AnnotationTest{
    String value() default "hi";
}