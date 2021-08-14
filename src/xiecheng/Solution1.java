package xiecheng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution1 {

    boolean[] vis;

    public List<List<Character>> permuteUnique(char[] nums) {
        List<List<Character>> ans = new ArrayList<List<Character>>();
        List<Character> perm = new ArrayList<Character>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(char[] nums, List<List<Character>> ans, int idx, List<Character> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Character>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int x = sc.nextInt();
        int y = sc.nextInt();

        int res = 0;

        char[] nums = new char[x+y];
        for (int i = 0; i < x+y; i++){

        }

    }
}
