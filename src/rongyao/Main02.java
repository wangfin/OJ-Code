package rongyao;

import java.util.*;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        // 找到大小写字母同时存在的字母，找不到就循环结束了
        // 执行子序列最优化
        // 减去这一轮用掉的大小写字母

        int[] str_low = new int[26];
        int[] str_up = new int[26];

        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){
                str_low[input.charAt(i) - 'a']++;
            }else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
                str_up[input.charAt(i) - 'A']++;
            }
        }

        // 初始化
        int[] vector = new int[26];
        for (int i = 0; i < 26; i++){
            vector[i] = 0;
        }

        for (int i = 0; i < 26; i++){
            if (str_up[i] > 0 && str_low[i] > 0){
                if (str_low[i] > str_up[i]){
                    vector[i] = str_up[i];
                }else{
                    vector[i] = str_low[i];
                }
            }
        }

        // 标志最大字符串的起始位置
        int flag = 0;
        // 连续字符的个数
        int con = 0;
        // 标志最大连续字符是多少位
        int max = 0;
        // 表示有没有
        boolean is = false;

        for (int i = 0; i < 26; i++){
            if (vector[i] != 0){
                is = true;
                break;
            }
        }

        if(is){
            boolean isAll = true;
            ArrayList<String> ress = new ArrayList<>();
            while (isAll){
                for (int i = 0; i< 26; i++){
                    if (vector[i] != 0){
                        con++;
                    }else{
                        if (con > max){
                            max = con;
                            // 最大连续字符的起始位置
                            flag = i - max;
                        }
                        con = 0;
                    }
                }
                String res = "";
                for (int i = flag; i < flag + max; i++){
                    char char1 = (char) ((char)i + 'A');
                    char char2 = (char) ((char)i + 'a');
                    res += String.valueOf(char1) + String.valueOf(char2);
                    vector[i] --;
                }
                ress.add(res);
                //System.out.println(res);

                flag = 0;
                max = 0;

                int sum = 0;
                for (int i = 0; i < 26; i++){
                    sum += vector[i];
                }
                if (sum == 0){
                    isAll = false;
                }
            }
            String[] res_list = new String[ress.size()];
            for (int i = 0; i < ress.size(); i++){
                res_list[i] = ress.get(i);
            }
            Arrays.sort(res_list);
            for (int i = 0; i < ress.size(); i++){
                System.out.println(res_list[i]);
            }
        }else{
            System.out.println("Not Found");
        }


    }












//        ArrayList<Character> upchar = new ArrayList<>();
//        ArrayList<Character> lowchar = new ArrayList<>();
//        for (char ch : input.toCharArray()){
//            if (Character.isUpperCase(ch)){
//                upchar.add(ch);
//            }else{
//                lowchar.add(ch);
//            }
//        }
//
//        ArrayList<Character> res = getUpLowChar(upchar, lowchar);
//
//        if (res.size() > 0){
//
//        }else{// 不存在
//            System.out.println("Not Found");
//        }
//
//
//
//
//
//    }
//
//    // 找到大小写同时存在的字母
//    public static ArrayList<Character> getUpLowChar(ArrayList<Character> upchar, ArrayList<Character> lowchar){
//
//        ArrayList<Character> res = new ArrayList();
//        for (char upch :upchar){
//            for (char lowch: lowchar){
//                if (Character.toLowerCase(upch) == lowch){
//                    res.add(upch);
//                    break;
//                }
//            }
//        }
//        return res;
//    }
//
//    // 连续子序列最优化
//    public static ArrayList<Character> maxLen(String input){
//        Character maxEnd, res = input.charAt(0);
//        for (int i = 0; i < input.length(); i++){
//            if
//        }
//
//    }

}
