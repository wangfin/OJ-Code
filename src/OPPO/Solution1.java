package OPPO;
import java.util.*;

public class Solution1 {
    public ArrayList<Integer> ProfectNumber (int temp) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2; i <= temp; i ++){
            if (checkPerfectNumber(i)){
                res.add(i);
            }
        }
        return res;
    }

    public static boolean checkPerfectNumber(int num){
        int sum = 1;
        for (int i = 2; i * i <= num; i++){
            if (num % i == 0){
                sum += i;
                if (i * i != num){
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        int temp = 100;
        ArrayList<Integer> res = new Solution1().ProfectNumber(temp);
        System.out.println(res);
    }
}
