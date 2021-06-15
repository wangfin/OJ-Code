package LeetCode242;

public class Solution {
    /**
     *
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 使用类似于map的映射，将字符映射为26个数组的值
     * 定义一个数组叫做record用来记录字符串s里字符出现的次数。
     * 需要把字符映射到数组也就是哈希表的索引下表上，因为字符a到字符z的ASCII是26个连续的数值，
     * 所以字符a映射为下表0，相应的字符z映射为下表25。
     *
     *
     */
    public boolean isAnagram(String s, String t) {
        // 设置一个映射数组
        int[] record = new int[26];
        // 遍历s
        for (char c : s.toCharArray()){
            record[c - 'a'] += 1;
        }
        // 遍历t
        for (char c : t.toCharArray()){
            record[c - 'a'] -= 1;
        }
        // 查看是否数组是否全部为0
        for (int i : record){
            if (i != 0)
                return false;
        }
        return true;
    }
}
