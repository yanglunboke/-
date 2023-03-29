package 递归;

import java.util.Scanner;

public class 汉诺塔 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        Hanno(n,'A','B','C');
    }
    public static void Hanno(int n,char a,char b,char c){
        if(n==1){
            move(a,c);
        }
        else{
            Hanno(n-1,a,c,b);
            move(a,c);
            Hanno(n-1,b,a,c);
        }
    }
    public static void move(char x,char y){
        System.out.println(x+""+"->"+""+y);
    }
}
