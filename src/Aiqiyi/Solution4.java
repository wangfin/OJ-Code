package Aiqiyi;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;
public class Solution4 {

        public static void main(String[] args) {
            final Scanner reader = new Scanner(System.in);
            int n = reader.nextInt();
            ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
            new Thread(() -> {
                try {
                    zeroEvenOdd.printZero(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    zeroEvenOdd.printEven(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    zeroEvenOdd.printOdd(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
}

class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSema = new Semaphore(1);
    // 奇数
    private Semaphore oddSema = new Semaphore(0);
    // 偶数
    private Semaphore evenSema = new Semaphore(0);


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void printZero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++){
            zeroSema.acquire();
            printNumber.accept(0);
            if ((i & 1) == 1){
                oddSema.release();
            }else{
                evenSema.release();
            }

        }
    }

    public void printEven(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++){
            if ((i & 1) == 0){
                evenSema.acquire();
                printNumber.accept(i);
                zeroSema.release();
            }
        }
    }

    public void printOdd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++){
            if ((i & 1) == 1){
                oddSema.acquire();
                printNumber.accept(i);
                zeroSema.release();
            }
        }
    }


}

