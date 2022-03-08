package rongyao;

import java.util.*;
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        String[] names = name.split(",");
        HashMap<String, Integer> map = new HashMap<>();
        // 遍历+1
        for (String na: names){
            map.put(na, map.getOrDefault(na, 0)+1);
        }
        boolean flag = true;

        for (Map.Entry<String, Integer> entry:map.entrySet()){
            if (entry.getValue() >= 100){
                flag = false;
            }
            char[] nas = entry.getKey().toCharArray();
            if (Character.isUpperCase(nas[0])){
                for (int i = 1; i < nas.length; i++){
                    if (!Character.isLowerCase(nas[i])){
                        flag = false;
                        break;
                    }
                }
            }else{
                flag = false;
            }
        }

        // 没有输入错误
        if (flag){
            int max_value = Integer.MIN_VALUE;
            ArrayList<String> name_arraylist = new ArrayList<>();

            for (Map.Entry<String, Integer> entry:map.entrySet()){

                if (entry.getValue() > max_value){
                    max_value = entry.getValue();
                }
            }

            for (Map.Entry<String, Integer> entry:map.entrySet()){
                if (entry.getValue() == max_value){
                    name_arraylist.add(entry.getKey());
                }
            }
            String[] name_list = new String[name_arraylist.size()];
            for (int i = 0; i < name_arraylist.size(); i++){
                name_list[i] = name_arraylist.get(i);
            }

            // 对相同票数的名字进行排序
            Arrays.sort(name_list);

//            for (int i = 0; i < name_list.length; i++){
//                System.out.println(name_list[i]);
//            }
            System.out.println(name_list[0]);
        }else{// 有输入错误
            System.out.println("error.0001");
        }

        // System.out.println(name_list[0]);
    }
}

// Tom,Lily,Tom,Lucy,Lucy,Tom,Jack
// Tom,Lily,Tom,Lucy,Lucy,Jack
