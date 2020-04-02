package 获取运行时类的所有结构.提供结构丰富的Person类;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2019 下午 3:12
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }

}
