package Shence;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 越界问题，所以说用Long来避免
        while (scanner.hasNextLong()) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            long m = scanner.nextLong();

            long count = 0;
            // 循环控制标志
            boolean flag = true;

            // 已经满足条件
            if (m <= x || m <= y) {
                count = 0;
                flag = false;
            } else {
                // 不满足条件，进行操作
                // m为正，xy有0
                if (x == 0 || y == 0) {
                    count = -1;
                    flag = false;
                }
                // 相加永久等于0
                if (m != 0 && x + y == 0) {
                    count = -1;
                    flag = false;
                }
                // 不满足条件，且x和y都小于0，xy只会越加越小
                if ( x < 0 && y < 0) {
                    // m为正，xy都为负数
                    count = -1;
                    flag = false;
                }

            }
            // 判断通过，进行操作
            // 若有一个大于等于m，就可以了
            while (flag && x < m && y < m) {
                // 选择一个较小的进行替换
                if (x <= y) {
                    x += y;
                } else {
                    y += x;
                }
                count++;
            }
            System.out.println(count);
        }
    }
}
