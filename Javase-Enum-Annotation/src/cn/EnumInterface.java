package cn;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

/**
 * 3.通过枚举类来实现接口:
 * 情况一：实现接口，实现抽象方法，和普通的class类实现接口方式一致
 * 情况二：让我们的枚举类的对象分别实现接口中的抽象方法
 *
 * @author 今天也要努力的小白
 * @date 2020/3/8 10:35
 */
public class EnumInterface {
    public static void main(String[] args) {

        infomethod spring = infomethod.SPRING;
        spring.method();//调用春天的方法
    }
}

interface info {
    public void method();
}

enum infomethod implements info {
    /**
     * 季节的四个枚举对象
     * 分别重写接口中的抽线方法
     * 以实现调用时不同的诉求
     */
    SPRING {
        @Override
        public void method() {
            System.out.println("春天");
        }
    },
    SUMMER {
        @Override
        public void method() {
            System.out.println("夏天");
        }
    },
    AUTUMN {
        @Override
        public void method() {
            System.out.println("秋天");
        }
    },
    WINTER {
        @Override
        public void method() {
            System.out.println("冬天");
        }
    };

}