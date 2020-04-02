package 自定义泛型练习; /**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import java.util.*;

/**
 * DAO操作数据库中的类,泛型<T>表示类名
 *
 * @author 今天也要努力的小白
 * @creat 2020/3/24 8:43
 */
public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        //错误的写法
//        List<T> values = (List<T>) map.values();
//        return values;
        //正确的写法
        ArrayList<T> t = new ArrayList<>();
        Collection<T> values = map.values();
        //1)用迭代器遍历
        Iterator<T> iterator = values.iterator();
        while (iterator.hasNext()){
            T t1 = iterator.next();
            t.add(t1);
        }
        //2)用增强for循环遍历
        for (T value : values) {
            t.add(value);
        }

        return t;
    }

    public void delete(String id) {
        map.remove(id);
    }

    public void print() {
        Set<Map.Entry<String, T>> entries = map.entrySet();
        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, T> entry = iterator.next();
            System.out.println(entry.getKey() + " ---> " + entry.getValue());
        }
    }
}