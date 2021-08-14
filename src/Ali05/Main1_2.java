package Ali05;
import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;

public class Main1_2 {
    /**
     * 第一题
     * @param nums
     * @return
     */

    public int maxServerIndex(int[] nums){
        long sum = Arrays.stream(nums).sum();
        long[] prefixSum = new long[nums.length + 1];
        long[] sufixSum = new long[nums.length + 1];
        BigInteger max = new BigInteger("0");
        int index = 0;
        for (int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
            sufixSum[i] = sum - prefixSum[i];
            BigInteger pre = new BigInteger(String.valueOf(prefixSum[i]));
            BigInteger suf = new BigInteger(String.valueOf(sufixSum[i]));
            BigInteger mul = pre.multiply(suf);
            if (max.compareTo(mul) < 0){
                max = mul;
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int len = reader.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++){
            nums[i] = reader.nextInt();
        }
        Main1_2 ma = new Main1_2();
        System.out.println(ma.maxServerIndex(nums));
        reader.close();
    }


}
