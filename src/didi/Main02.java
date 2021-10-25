package didi;
import java.util.*;

public class Main02 {
    /**
     * 程序员小明这几天在看《三国演义》。
     * 今天他看到了“火烧赤壁”这一回：诸葛亮在七星坛终于祭来了东南风，老将黄盖带着火药准备对曹操发动火攻。
     * 因为曹操的船都用铁链相连，如果其中一条船被火烧着，其他的船都会起火。最终，曹操大败。
     * 看着看着突然想到一个问题：如果当时曹操的船并没有全部连在一起，而只是部分船用铁链连在一起。如果一条船着火，所有与这条船连在一起的船也会着火。
     * 假定一共有N条船，这些船的编号分别为1、2、3、......、N。如果1号船着火，并且告诉你哪些船是相连的，请问一共会有多少条船着火？
     *
     * 输入描述
     * 单组输入。 第1行输入两个正整数N和M，其中N表示船的总数，M表示船之间的连接关系数量，N<=1000，M<=100000。N和M之间用空格隔开。 接下来M行每行输入两个正整数，表示相连的两条船的编号，编号小的在前，编号大的在后。两个正整数之间用空格隔开。
     *
     * 输出描述
     * 如果1号船着火，输出会着火的船的总数量。
     *
     * 样例输入
     * 5 3
     * 1 2
     * 2 3
     * 4 5
     * 样例输出
     * 3
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] links = new int[M][2];
        for (int i = 0; i < M; i++){
            links[i][0] = sc.nextInt();
            links[i][1] = sc.nextInt();
        }

        // 判断状态
        int[] flags = new int[N];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++){

        }




    }


}
