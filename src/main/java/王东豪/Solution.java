package 王东豪;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double r = sc.nextDouble();
        double h = sc.nextDouble();

        double s=Math.PI*r*r;

        System.out.println(s*h);
    }

}
