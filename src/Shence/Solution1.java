package Shence;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();

            Stack<Integer> stack = new Stack<>();
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();

            for (int i = 0; i < chars.length; i++) {
                if(chars[i] == '('){
                    stack.push(i);
                }else if (chars[i] == ')'){
                    treeMap.put(stack.pop(),i);
                }
            }

            System.out.println(treeMap.keySet().size());
            for (Integer key : treeMap.keySet()){
                System.out.println(key);
                System.out.println(treeMap.get(key));
            }
        }
    }
}
