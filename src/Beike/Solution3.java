package Beike;

public class Solution3 {
    public static int sum(int n) {
        int res = 0;
        for (int i = 0; i < n; i++){
            res += n - i - 1;
        }
        return res;
    }

    public int section(int[] a, int t){
        int len = a.length;
        int res = 0;
        for (int i = 0; i < len; i++){
            for (int j = i+1; j < len; j++){
                int x = a[i]^a[j];
                // 结果相等
                if (x == t){
                    break;
                }else{
                    res += sum(j-i+1);
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int x = 3;
        int res0 = new Solution3().sum(x);
        System.out.println(res0);
        int[] a = new int[]{2, 4, 8};
        int t = 6;
        int res = new Solution3().section(a, t);
        System.out.println(res);
    }
}
