package Q$A;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

/**
 *@author 今天也要努力的小白
 *@creat 2020/3/31 19:28
 */
@MyAnnotation
public class Student {
    private String name;
    private int age;

    public Student() {

    }

    @MyAnnotation(value="hi")
    @Deprecated
    @SuppressWarnings("123")
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("这是一个两个参数的构造器");
    }
}
