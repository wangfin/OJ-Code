package xiaohongshu;

import java.util.Scanner;

public class Solution2 {
    /**
     * 段式回文类似于回文，最小的单位可以是多个字符而不仅是单个字母 例如：一般的回文字符串形式如“level、noon、civic”，而“gotogo”不是，
     * 但如果我们把“gotogo”分为“go”、“to”、“go”三段，则可以认为“go to go”是段式回文
     * 给定一个字符串s（s仅由小写英文字母组成，且s长度<= 30），请将s分割成一些子串，使每个子串都是段式回文。
     * 返回s所有可能的分割方案的个数
     * 例如gotogo，可有6种分隔方案，即：[g, o, t, o, g, o], [g, o, t, ogo], [g, oto, g, o], [g, otogo], [gotog, o], [gotogo]
     *
     * 输入描述
     * 字符串s
     *
     * 输出描述
     * 分隔方案个数
     */
    public static int ans = 0;
    public int partitionNumber(String text) {
        dfs(text);
        return ans;
    }

    public static void dfs(String s){
        if ("".equals(s)){
            ans += 1;
            return;
        }
        for (int i = 0; i < s.length(); i++){
            String tmp = s.substring(0, i+1);
            if (isboolean(tmp)){
                if (i != s.length() - 1){
                    dfs(s.substring(i+1, s.length()));
                }else{
                    dfs("");
                }
            }
        }

    }

    public static boolean isboolean(String s){
        boolean is = false;
        if (s.length() != 1){
            is = divide(s, 0) > 1;
        }else{
            is = true;
        }
        return is;
    }
    public static int divide(String s, int n){
        int len = s.length();
        if (s.equals(""))
            return n;
        for (int i = 0; i < len/2; i++) {
            if (s.substring(0, i + 1).equals(s.substring(len - i - 1, len))) {
                return divide(s.substring(i + 1, len - i - 1), n + 2);
            }
        }
        return n+1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _text;
        try {
            _text = in.nextLine();
        } catch (Exception e) {
            _text = null;
        }

        res = new Solution2().partitionNumber(_text);
        System.out.println(String.valueOf(res));

    }

}
