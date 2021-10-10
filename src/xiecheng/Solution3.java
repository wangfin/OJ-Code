package xiecheng;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入以空行结束
        ArrayList<String> arrayList = new ArrayList<>();
        while (true){
            String s = sc.nextLine();
            if(s.equals(""))
                break;
            arrayList.add(s);
        }
        int n = arrayList.size();
        Map<String, Integer> chat = new HashMap<>();
//        String[] names = new String[n];
//        String[] words = new String[n];
        Set<String> words = new HashSet<>();
        for (int i = 0; i < arrayList.size(); i++){
            String name = arrayList.get(i).split(":")[0];
            String word = arrayList.get(i).split(":")[1];
//            names[i] = name;
//            words[i] = word;
            // 存在这个名字，+1
            if (chat.containsKey(name)){
                if (words.contains(word)){
                    chat.replace(name, chat.get(name) - 1);
                }else{
                    words.add(word);
                    chat.replace(name, chat.get(name) + 1);
                }
            }else{// 不存在，设为1
                if (words.contains(word)){
                    chat.put(name, 0);

                }else{
                    words.add(word);
                    chat.put(name, 1);
                }
            }
        }

        ArrayList<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: chat.entrySet()){
            if (entry.getValue() <= 0){
                res.add(entry.getKey());
            }
        }
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }

    }
}
