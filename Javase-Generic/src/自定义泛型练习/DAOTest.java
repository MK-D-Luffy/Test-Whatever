package 自定义泛型练习;
/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 * 道路,很远!脚步,更长!
 */

import org.junit.jupiter.api.Test;

/**
 * 测试类,new DAO对象测试DAO中的方法
 *
 *@author 今天也要努力的小白
 *@creat 2020/3/24 8:48
 */
public class DAOTest {
    @Test
    public void test() {

        User user1 = new User(1, 152, "sdsda");
        User user2 = new User(2, 121, "sdsdsda");
        User user3 = new User(3, 131, "adsdxczxza");
        User user4 = new User(4, 122, "sfasdsdasxsddsza");

        DAO<User> userDAO = new DAO<>();

        userDAO.save("1",user1);
        userDAO.save("2",user2);
        userDAO.save("3",user3);
        userDAO.save("4",user4);

        userDAO.delete("1");

        System.out.println(userDAO.list());

        userDAO.print();

    }
}
