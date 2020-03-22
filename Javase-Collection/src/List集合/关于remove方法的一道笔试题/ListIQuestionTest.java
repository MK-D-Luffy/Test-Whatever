package List集合.关于remove方法的一道笔试题; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * 区分List中remove(int index)和remove(Object obj):
 * remove(int index)List中特有的,
 * remove(Object obj)Collection中继承的.
 *
 * 在List集合中的remove方法如果使用int类型的数据调用，默认视为调用remove（index i），
 * 如果想要移除整数，需要调用Integer构造器，将int类型手动转换为Integer。(!!!)
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/20 10:14
 */
public class ListIQuestionTest {
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }

    private void updateList(List list) {
        //形参为int型时，默认视为index
        list.remove(2);

        //要移除该元素，需要装箱，调用new Integer()
        list.remove(new Integer(2));
    }
}
