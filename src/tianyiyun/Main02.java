package tianyiyun;

import java.util.*;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int ansm = 0;
        int ansh;
        if(m == 0){
            ansh = 12 - h;
        }else{
            ansh = 11 - h;
            ansm = 60 - m;
        }
        System.out.println(ansh + " " + ansm);
    }
}
