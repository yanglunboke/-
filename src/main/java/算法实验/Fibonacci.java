package 算法实验;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print(fib(i)+" ");
        }
    }
    public static int fib(int n){
        if(n==1||n==2){
            return 1;
        }else{
            return (fib(n-1)+fib(n-2));
        }
    }
}


