package cn;

/**
 * 1.自定义枚举类
 */
public class enumTest {
    public static void main(String[] args) {
        Person xiaozhao = Person.xiaozhao;
        System.out.println(xiaozhao);
        System.out.println(Person.xiaoli);
        System.out.println(Person.xiaozhang);
    }
}

class Person {
    //定义枚举类的属性( 对象的属性 )
    private final String name;
    private final String gender;
    private final String age;

    //私有化构造器，外部无法访问，创建新的对象，实现枚举类的有限个.
    private Person(String name, String gender, String age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    //内部创建类对象
    public static Person xiaozhang = new Person("xiaozhang", "男", "18");
    public static Person xiaozhao = new Person("xiaozhao", "男", "125");
    public static Person xiaoli = new Person("xiaoli", "男", "52");


    //外部获取，枚举类的属性
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    //重写tostring方法
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}