package Shunfeng;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int n = sc.nextInt();
        ArrayList<int[]> weights = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int[] weight = new int[5];
            for (int j = 0; j < 5; j++){
                weight[j] = sc.nextInt();
            }
            weights.add(weight);
        }

        int[] scores = new int[n];
        int max_score = 0;

        for (int i = 0; i < n; i ++){
            scores[i] += a * weights.get(i)[0] + b * weights.get(i)[1] + c * weights.get(i)[2] + d * weights.get(i)[3] + e * weights.get(i)[4];
        }
        for (int i = 0; i < n; i++){
            if (scores[i] > max_score){
                max_score = scores[i];
            }
        }
        System.out.println(max_score);
        int max_num = 0;
        ArrayList<Integer> max_index = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (scores[i] == max_score){
                max_num++;
                max_index.add(i);
            }
        }
        System.out.println(max_num);
        for (int i = 0; i < max_num; i++){
            System.out.println(max_index.get(i) + 1);
        }

    }
}
