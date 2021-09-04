package zhongxing;

import java.util.*;
public class Solution2 {
    public int ArrayDistance(int[] a, int m, int k){
        int n = a.length;
        int[] b = new int[n];
        // 填充b为1
        Arrays.fill(b, 1);
        int res = 0;
        ArrayList<int[]> array = new ArrayList<>();
        for (int i = 0; i < n; i ++){
            int tmp = b[i];
            for (int j = 1; j <= m; j++){
                b[i] = j;
                int[] tmp_list = Arrays.copyOf(b,n);
                array.add(tmp_list);
                if (dis(a, b) <= k){
                    res++;
                }
            }
            b[i] = tmp;
        }
        return res % (10^9+7);
    }

    public static int dis(int[] a, int[] b){
        int res = 0;
        for (int i = 0; i < a.length; i++){
            res += Math.abs(a[i] - b[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = new int[]{2,2};
        int m = 2;
        int k = 50;
        int res = new Solution2().ArrayDistance(a, m, k);
        System.out.println(res);
    }
}
