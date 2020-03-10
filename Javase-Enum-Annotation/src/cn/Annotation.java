package cn;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解的使用
 * <p>
 * 1. 理解Annotation:
 * ① jdk 5.0 新增的功能
 * <p>
 * ② Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。通过使用 Annotation,
 * 程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 * <p>
 * ③在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android
 * 中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗
 * 代码和XML配置等。
 * <p>
 * 2. Annocation的使用示例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 *
 * @author 今天也要努力的小白
 * @Override: 限定重写父类方法, 该注解只能用于方法
 * @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 * @SuppressWarnings: 抑制编译器警告
 * <p>
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 * <p>
 * 3.自定义注解
 * ①定义Annotation类型（即注解类）时必须要有@interface关键字
 * ②定义内部成员，通常用value表示
 * ③可以用default指定成员的默认值
 * ④如果自定义注释没有成员，就是一个标识作用
 * 调用:@name
 * @annotation() 如果注解有成员在使用时需要指明成员变量的值
 * 自定义注解必须配上注解的信息处理流程(使用反射)才有意义
 * 自定义注解通常都会指定这两个元注解: Retention、Target
 * <p>
 * 4.jdk提供的4种元注解：
 * 元数据(@interface)：修饰数据的数据称为元数据
 * 元注解：修饰注解的注解称为元注解
 * Retention(保留):指定修饰符的生命周期:SOURCE\CLASS(默认行为)\RUNTIME
 * 只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 * Target:用于指定被修饰的Annotation能用于修饰哪些元素(简单的说就是指定修饰的范围)
 * *****出现频率较低（了解）*******
 * Documeted:表示所修饰的注解在被javadoc解析时，保留下来
 * Inherited:被它修饰的annotation将具有继承性
 * <p>
 * 5.通过反射来获取注解信息
 * <p>
 *
 * 6.jdk8中注解的新特性:可重复注解，类型注解
 * <p>
     * 6.1 可重复注解:① 在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
     *               ② MyAnnotation的Target和Retention等元注解与MyAnnotations相同。
     * 6.2 类型注解:
             * ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（用于声明如:<@annotation T>泛型声明）。
             * ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。(用于类型如: @annotation int)
 * @author 今天也要努力的小白
 * @date 2020/3/8 14:45
 */


//元数据 包含成员变量
@Retention (RetentionPolicy.RUNTIME)//元注解
@Target ({ElementType.TYPE, ElementType.FIELD})
@interface annotation {
    //定义内部成员变量
    String value() default "hello";
}

//标记  没有成员
@interface annotation1 {
}


public class Annotation {

    public static void main(String[] args) {

    }

}
