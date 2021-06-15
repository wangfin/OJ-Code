package LeetCode804;

import java.util.TreeSet;

public class Solution {
    /**
     * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串，
     * 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
     * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。
     * 例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作单词翻译。
     *
     * 返回我们可以获得所有词不同单词翻译的数量。
     *
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        // 摩斯码
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        // 构建TreeSet
        TreeSet<String> set = new TreeSet<>();
        // 遍历整个单词列表
        for(String word: words){
            StringBuilder res = new StringBuilder();
            // 遍历单词的每一个字母
            for(int i = 0; i < word.length(); i ++){
                // 单词中每一个字母的摩斯码
                String mosi_code = codes[word.charAt(i) - 'a'];
                // 输入到输出中
                res.append(mosi_code);
            }
            // 输入到集合中
            set.add(res.toString());
        }
        return set.size();
    }
}
