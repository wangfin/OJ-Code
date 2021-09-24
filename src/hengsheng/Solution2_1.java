package hengsheng;

import java.util.*;

public class Solution2_1 {
    public static void main(String[] args) {
        int n=10;
        ArrayList<Integer>list=new ArrayList<>();
        //只是用一个list来存每个人的编号。
        for(int i=0;i<n;i++){
            list.add(i+1);
        }
        int k=10;
        System.out.println(method(list,k));;
    }

    public static int method( ArrayList<Integer> list,int k){
        int count=0;
        int num=0;
        for(int j=0;j<list.size();j++){
            num++;
            if(num==3){
                //每次都是1-2-3，到了3之后，令num=0，下次又可以1-2-3
                num=0;
                count++;
                //判断count=k。如果是，直接返回，不是就移掉这个数继续往后
                if(count==k){
                    return list.get(j);
                }
                list.remove(j);
                //这边有一个需要注意的是，如果移掉了当前，原本的j+1就到了j，如果j不减的话，就会直接漏掉那个数
                //所以这边j--
                j--;
            }
            //如果到了尾部，下一次又会到0；所以这边j=-1，j++刚好j等于0
            if(j==list.size()-1){
                j=-1;
            }
        }
        //没有取到，返回-1
        return -1;
    }
    
}
