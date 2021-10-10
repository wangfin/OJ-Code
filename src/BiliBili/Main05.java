package BiliBili;

import java.util.Scanner;

public class Main05 {
    public static boolean isAdmin(String userld) {
        return userld.toLowerCase() == "admin";
    }
        public static void main(String[] args){
        System.out.println(isAdmin("Admin"));
    }

}
