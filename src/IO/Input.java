package IO;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    // 用来记录JAVA的输入，用于编程题读取数据
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        // 一行输入
//        int n = sc.nextInt();
//        double t = sc.nextDouble();
//        String s = sc.nextLine();

        // 不知道有多少行输入(或者多测试用例）。如果是先获取所有输入，再集中处理，使用ctrl+D结束输入。
//        ArrayList<String> arrayList = new ArrayList<>();
//        while (sc.hasNext()){
//            arrayList.add(sc.next());//nextLine()/next()看情况使用
//        }
//
//        System.out.println(arrayList.toString());

        // 输入为0结束输入
//        ArrayList<String> arrayList = new ArrayList<>();
//        int num;
//        while ((num = sc.nextInt()) != 0){
//            System.out.println(num);
//        }

        // 空行结束输入
//        while (true){
//            String s = sc.nextLine();
//            if(s.equals(""))
//                break;
//        }

        // 知道有几行输入

        //格式
        //2
        //5
        //1 2 4 5 6
        //6
        //1 2 3 4 5 6
//        Scanner reader = new Scanner(System.in);
//        int m = reader.nextInt();
//        for (int i=0 ; i<m ; i++) {
//            int n = reader.nextInt() ;
//            int [] array = new int[n] ;
//            for (int j = 0; j < n; j++) {
//                array[j] = reader.nextInt();
//            }
//        }

        // 输入以空行结束
        ArrayList<String> arrayList = new ArrayList<>();
        while (sc.hasNext()){
            String s = sc.nextLine();
            if(s.equals("EOF"))
                break;
            arrayList.add(s);
        }


    }


}
