package Tenxun;
import java.util.*;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < input.length(); i++){
            char s = input.charAt(i);
            int sum;
            if (Character.isDigit(s)){
                st.push((int)s);
            }else if (s == '@'){
                sum = st.pop() | (st.pop() + input.charAt(i+1));
                i ++;
                st.push(sum);
            }else if (s == 'x'){
                sum = st.pop() * input.charAt(i+1);
                i++;
                st.push(sum);
            }else{
                if (st != null){

                }
            }
        }
    }

}
