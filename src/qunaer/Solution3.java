package qunaer;

public class Solution3 {
    /**
     * Lisa 喜欢字符串，尤其是长字符串。对于每个字符串，她都有专门的评价体系来判断字符串的优雅程度。
     * 她定义一个字符串 S[1..3n−2] (n≥2) 是一个半回文当且仅当它满足 S[i]=S[2n−i]=S[2n+i− 2] (1≤i≤n) .
     * 例如dfgfdfg是一个半回文串，而dfgjfdfgj不是。现在，Lisa 生成了一些长字符串。她请求你帮助找出有多少个半回文子串。
     */
    public int solution(int n, String str) {
        int res = 0;
        //int len = (str.length() + 2)/3;
        int num = 2;
        while (3 * num < str.length()){
//            if (str.charAt(i) == str.charAt(2*len-i) && str.charAt(i) == str.charAt(2*len+i-2)){
//                res++;
//            }
        }


        return res;
    }
    public static void main(String[] args) {
        int n = 1;
        String str = "dfgfdfg";
        int res = new Solution3().solution(n, str);
        System.out.println(res);
    }
}
