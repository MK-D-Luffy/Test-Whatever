/**
 * 今天也要元气满满啊！
 * 今天也要加油啊！
 */

import java.util.Scanner;

import static java.lang.System.*;

/**
 * @author 今天也要努力的小白
 * @date 2020/3/8 22:18
 */
public class Welcome {

    public static void welcome() {
        out.println("------------welcome------------");
        out.println("---------FamilyAccount---------");
        out.println("|        1.收支明细             |");
        out.println("|        2.登记收入             |");
        out.println("|        3.登记支出             |");
        out.println("|        4.退  出              |");
        out.println("-------------------------------");
        out.print("请选择1-4:");
        switch (new Scanner(System.in).next()) {
            case "1":

                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                out.print("退出成功!");
                exit(1);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + new Scanner(in));
        }
    }
}
