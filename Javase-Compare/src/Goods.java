/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

/**
 * 商品类(实现了Comparable接口)
 * 为什么不能用Comparator接口来实现:
 * Comparator接口接收两个参数，而对于我们调用排序的放法sort（）来说，只接收一个
 * 参数，无法实现给Comparator正确传参。而对于comparable来说它只接收一个参数，
 * 所以一般类可以通过直接实现comparable接口的方式，重写compareTo（obj）方法。
 * 通过调用sort，就可以达成compareTo(obj)的调用了。
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/16 15:29
 */
public class Goods implements Comparable {
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (Integer.compare(this.price, goods.price) == 0) {
                //因为this.name是String类,所以这里调用的实际上是String类实现的compareTo（）方法。
                return -this.name.compareTo(goods.name);
            }
            return Integer.compare(this.price, goods.price);
        }
        throw new RuntimeException("请输入正确的类");
    }

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
