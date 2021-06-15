package LeetCode452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /**
     * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
     * 由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
     *
     * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。
     * 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xstart≤ x ≤ xend，则该气球会被引爆。
     * 可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
     *
     * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
     *
     * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
     * 输出：2
     * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
     *
     */

    public int findMinArrowShots(int[][] points) {
        // 数组为空
        if (points.length <= 0){
            return 0;
        }
        // 对数组中每个[]的左端点进行排序
        points = sortRows(points);

        // 初始化参数
        int shoot_num = 1;  // 需要的射击次数
        // 射击区间开始结尾
        int shoot_begin = points[0][0];
        int shoot_end = points[0][1];

        for (int i = 1; i < points.length; i ++){
            // 因为已经按照左区间排序了，所以只要考虑右区间
            // 射击右区间只要包含另一个气球区间，那么射击左区间一定要更换
            if (shoot_end >= points[i][0]){
                shoot_begin = points[i][0];
                // 右边区间完全包括另一个气球的区间，需要区间缩小
                if (shoot_end > points[i][1]){
                    shoot_end = points[i][1];
                }
            }else{ // 没有包含到，那么就需要再加一个射手了
                shoot_num ++;
                shoot_begin = points[i][0];
                shoot_end = points[i][1];
            }
        }


    return shoot_num;

    }

    private static int [][] sortRows(int[][] arr) {
        //排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {

                if (x[0] > y[0]) {
                    return 1;
                } else if (x[0] < y[0]) {
                    return -1;
                } else {
                    return 0;
                }

            }
        });
        return arr;
    }

    public static void main(String[] args) {
        // [[-2147483646,-2147483645],[2147483646,2147483647]]
        // [[10,16],[2,8],[1,6],[7,12]]
        // [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
        int [][] points = new int[][]{{3,9}, {7,12}, {3,8}, {6,8}, {9,10}, {2,9}, {0,9}, {3,9}, {0,6}, {2,8}};
        // int [][] points = new int[][]{{-2,-1}, {-4,-2}, {1,2}};
//        int res = new Solution().findMinArrowShots(points);
//
//        System.out.println(res);
        points = sortRows(points);

        System.out.println(Arrays.deepToString(points));
    }

}
