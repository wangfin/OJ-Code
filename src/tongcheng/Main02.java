package tongcheng;

import java.util.*;

public class Main02 {
    public static int function(String str) {
        HashMap<Character, Integer> cal = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < str.length(); i++){
            if (cal.get(str.charAt(i)) != null){
                left = Math.max(left, cal.get(str.charAt(i)) + 1);
            }
            cal.put(str.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }

        // 在这里输入代码
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(function(in.next()));
        }
    }
}
