package 泛型的使用; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

/**
 * 自定义泛型类
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/23 16:38
 */
public class GenericClass<T> {
    private String name;
    private T t;

    @Override
    public String toString() {
        return "泛型的使用.GenericClass{" +
                "name='" + name + '\'' +
                ", t=" + t +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public GenericClass(String name, T t) {
        this.name = name;
        this.t = t;
    }
}
