package Offer38;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     *
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     *
     * 示例：
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     *
     * 回溯
     * 1.终止条件： 当 x = len(c) - 1 时，代表所有位已固定（最后一位只有 1 种情况），则将当前组合 c 转化为字符串并加入 res ，并返回；
     * 2.递推参数： 当前固定位 x ；
     * 3.递推工作： 初始化一个 Set ，用于排除重复的字符；将第 x 位字符与 i ∈ [x, len(c)] 字符分别交换，并进入下层递归；
     *     1.剪枝： 若 c[i] 在 Set 中，代表其是重复字符，因此 “剪枝” ；
     *     2.将 c[i] 加入 Set ，以便之后遇到重复字符时剪枝；
     *     3.固定字符： 将字符 c[i] 和 c[x] 交换，即固定 c[i] 为当前位字符；
     *     4.开启下层递归： 调用 dfs(x + 1) ，即开始固定第 x + 1 个字符；
     *     5.还原交换： 将字符 c[i] 和 c[x] 交换（还原之前的交换）；
     *
     */
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x){
        if (x == c.length - 1){
            // 添加排列方案
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++){
            // 重复，因此剪枝
            if (set.contains(c[i]))
                continue;
            set.add(c[i]);
            // 交换，将 c[i] 固定在第 x 位
            swap(i ,x);
            // 开启固定第 x + 1 位字符
            dfs(x + 1);
            // 恢复交换
            swap(i ,x);
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        String s = "abc";
        String[] res = new Solution().permutation(s);
        System.out.println(Arrays.toString(res));
    }
}
