package Meituan;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution5 {
    /**
     * 题目描述：
     * 小美天天刷题，收获了很多ac。为了纪念这些ac，小美记下了一个长度为n的仅有a和c组成的字符串。
     * 小团天天摸鱼不刷题，所以ac没有小美多。小团决定在小美睡觉的时候把小美字符串中的ac通过交换相邻两个字符全部消除。
     * 即通过一系列交换相邻字符的操作使得操作后的串中不存在ac这个字串。小团想知道他至少要交换多少次才能达成他的目的。
     *
     * 输入描述
     * 第一行有一个整数n(1<=n<=100000)，代表小美拥有的字符串长度。
     * 第二行有一个仅由a和c组成的字符串，代表小美的字符串。
     *
     * 输出描述
     * 输出一个整数，代表小团想知道的答案。
     * 如样例中先交换前两个字符再交换中间两个字符即可使小美的字符串变成ccaa。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        String s = sc.next();
        char[] ch = s.toCharArray();

        int res = 0;
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (ch[i] == 'c'){
                array.add(i);
            }
        }
        for (int j = 0; j < array.size(); j++){
            res += array.get(j) - j;
        }

        System.out.println(res);
    }
}
