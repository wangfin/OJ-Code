package didi;
import java.util.*;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float[] leng = new float[n];
        for (int i = 0; i < n; i++){
            leng[i] = sc.nextFloat();
        }
        Arrays.sort(leng);

        int res = 1;
        for (int i = 1; i < n; i++){
            if (leng[i] > leng[i-1]){
                res++;
            }
        }

        System.out.println(res);

    }
}
