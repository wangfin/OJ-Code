package xiaohongshu;

import java.util.Scanner;

public class Solution3 {
    /**
     * 薯队长看到了一颗神奇的树，树上有在每个结点上都住的一只蜗牛，树的结点数是N(N<=10000)。
     * 假设每只蜗牛的爬行速度都是一样的，树的每条边代表着蜗牛通过需要的时间（不超过1000）。
     * 如果在两个结点上的蜗牛到达对方的时间不超过K（K <= 10^9)，我们认为这两个蜗牛是好朋友。
     * 现在给定蜗牛们居住的树，薯队长想知道蜗牛们有多少对好朋友。
     * 对于30%的数据，N<=20
     * 对于50%的数据，N<=2000
     * 对于100%的数据，N<=10000
     *
     * 输入描述
     * 第一行两个正整数N, K。
     * 之后一行有3 * (N-1)个整数，每三个正整数a,b,c代表从结点a到结点b有一个边，时间为c
     * 输入即a[0] b[0] c[0] a[1] b[1] c[1] ....
     * 注意结点的编号不一定是从0开始，但树一定是合法的。
     *
     * 输出描述
     * 输出一行，为好朋友的对数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int[] node1 = new int[N];
        int[] node2 = new int[N];
        int[] len = new int[N];
        for (int i = 0; i < N; i++){
            node1[i] = Integer.parseInt(ss[3*i]);
            node2[i] = Integer.parseInt(ss[3*i+1]);
            len[i] = Integer.parseInt(ss[3*i+2]);
        }
        int node_num = 0;
        for (int i = 0; i < N; i++){
            if (len[i] < K){
                node_num++;
            }
        }
        System.out.println(node_num * 2);


    }
}
