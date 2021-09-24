package Lazada;

import java.util.*;

public class Main01 {
    /**
     * abcdabcde
     * xxxrryyyyyyzzg
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入以空行结束
        //ArrayList<String> arrayList = new ArrayList<>();
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(compression(s));
            //arrayList.add(s);
        }

//        for (int i = 0; i < arrayList.size(); i++){
//            System.out.println(compression(arrayList.get(i)));
//        }

    }

    public static String compression(String input){
        StringBuffer sb = new StringBuffer();
        int count = 1;
        for (int i = 0; i < input.length()-1; i++){
            char c = input.charAt(i);
            char nextc = input.charAt(i+1);
            if (c == nextc) count++;
            else{
                if (count != 1){
                    sb.append(count);
                    count = 1;
                }
                sb.append(c);
            }
        }
        if (count != 1)
            sb.append(count);
        sb.append(input.charAt(input.length()-1));
        return sb.toString();
    }
}
