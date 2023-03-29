package 搜索算法;

import java.util.Scanner;

public class n选r个 {
    public static void main(String[] args) {
        int n,r;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        r=sc.nextInt();
        int[] a=new int[r+1];
        a[0]=r;
        comb(n,r,a);
    }
    public static void comb(int n,int r,int[] a){
        int i,j;
        for(i=n;i>=r;i--) {
            a[r] = i;
            if (r > 1) {
                comb(i - 1, r - 1, a);
            } else {
                for (j=a[0]; j>0; j--) {
                    System.out.print(a[i] + " ");
                }
                System.out.println(a[i]);
            }
        }
    }
}
