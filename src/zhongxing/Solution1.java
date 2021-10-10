package zhongxing;

import java.util.Arrays;

public class Solution1 {
    public int diskRead(int[] a, int pos){
        int n = a.length;
        // 对a排序
        Arrays.sort(a);
        int res = a[n-1] - a[0];
        res += Math.min(Math.abs(pos-a[0]), Math.abs(pos-a[n-1]));

        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 5};
        int pos = 3;
        int res = new Solution1().diskRead(a, pos);
        System.out.println(res);
    }
}
