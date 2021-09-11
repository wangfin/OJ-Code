package Meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {
    /**
     * 题目描述：
     * 小美想坐公交去找小团玩。美团市中共有n个公交站，编号为1到n。
     * 同时也有m条公交线路，编号为1到m。小美想知道对于每一对公交站( i , j ) 从编号为 i 的站坐公交到编号为 j 的站至少需要乘坐几条不同的公交线路。
     *
     * 输入描述
     * 第一行有两个空格隔开的整数n,m(1<=n<=500 , 1<=m<=500 且1<=n+m<=500)，代表公交站的个数和公交线路的条数。
     * 接下来n行，每一行开头有一个整数k(1<=k<=m)，代表从这个站可以乘坐k条不同的公交线路。接下来有k个整数，代表这k条公交线路的编号。数字间用空格隔开。
     *
     * 输出描述
     * 输出一个n×n的矩阵，矩阵中第 i 行第 j 列的数代表从编号为 i 的站坐到编号为j的站至少需要乘坐多少条不同的公交线路。矩阵中每行中的元素由单个空格隔开，且行末不能有空格。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] ss = new String[n];
        ArrayList<int[]> bus = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ss[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++){
            String[] sss = ss[i].split(" ");
            int k = Integer.parseInt(sss[0]);
            int[] b = new int[k];
            for (int j = 1; j <= k; j++){
                b[j] = Integer.parseInt(sss[j]);
            }
            bus.add(b);
        }
//        int[] line = new int[m];
//        for (int i = 0; i < m; i++){
//            for (int j = 0; j < bus.size(); j++){
//                if (Arrays.asList(bus.get(i)).contains(i)){
//
//                }
//            }
//        }

        int[][] res = new int[n][n];
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j++){
                // 直达
                if (Arrays.asList(bus.get(i)).contains(bus.get(j))){
                    res[i][j] = res[j][i] = 1;
                }


            }
        }
        System.out.println(res.toString());


    }

    public static boolean isarrive(int[] a, int[] b){
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < b.length; j++){
                if (a[i] == b[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
