package BiliBili;

import java.util.*;

public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int[] tree = new int[]{10,6,15,1,8,13,18,12,14,17,19};
        if (k >= 0 && k < tree.length){
            Arrays.sort(tree);
            System.out.println(tree[k-1]);
        }else{
            System.out.println(-1);
        }

    }
}
