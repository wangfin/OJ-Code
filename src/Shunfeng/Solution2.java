package Shunfeng;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] map = new int[m][3];
        int[][] point = new int[q][2];
        for (int i = 0; i < m; i++){
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
            map[i][2] = sc.nextInt();
        }
        for (int i = 0; i < q; i++){
            point[i][0] = sc.nextInt();
            point[i][1] = sc.nextInt();
        }

        for (int i = 0; i < q; i++){
            int max_res = 0;
            for (int j = point[i][0]-1; j < point[i][1]-1; j++){
                if (map[j][2] > max_res){
                    max_res = map[j][2];
                }
            }
            System.out.println(max_res);
        }




    }
//    public static int[] getShortestPaths(int[][] adjMatrix) {
//        int[] result = new int[adjMatrix.length];   //用于存放顶点0到其它顶点的最短距离
//        boolean[] used = new boolean[adjMatrix.length];  //用于判断顶点是否被遍历
//        used[0] = true;  //表示顶点0已被遍历
//        for(int i = 1; i < adjMatrix.length; i++) {
//            result[i] = adjMatrix[0][i];
//            used[i] = false;
//        }
//
//        for(int i = 1;i < adjMatrix.length;i++) {
//            int min = Integer.MAX_VALUE;    //用于暂时存放顶点0到i的最短距离，初始化为Integer型最大值
//            int k = 0;
//            for(int j = 1;j < adjMatrix.length;j++) {  //找到顶点0到其它顶点中距离最小的一个顶点
//                if(!used[j] && result[j] != -1 && min > result[j]) {
//                    min = result[j];
//                    k = j;
//                }
//            }
//            used[k] = true;    //将距离最小的顶点，记为已遍历
//            for(int j = 1;j < adjMatrix.length;j++) {  //然后，将顶点0到其它顶点的距离与加入中间顶点k之后的距离进行比较，更新最短距离
//                if(!used[j]) {  //当顶点j未被遍历时
//                    //首先，顶点k到顶点j要能通行；这时，当顶点0到顶点j的距离大于顶点0到k再到j的距离或者顶点0无法直接到达顶点j时，更新顶点0到顶点j的最短距离
//                    if(adjMatrix[k][j] != -1 && (result[j] > min + adjMatrix[k][j] || result[j] == -1))
//                        result[j] = min + adjMatrix[k][j];
//                }
//            }
//        }
//        return result;
//    }

}
