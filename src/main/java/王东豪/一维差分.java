package 王东豪;

import java.util.Scanner;

public class 一维差分 {
    public static void main(String[] args) {
        int n,k;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        k=scanner.nextInt();
        int[] sum = new int[n+10];
        int[] chafen = new int[n+10];
        for(int i=1;i<=n;i++){
            sum[i]=scanner.nextInt();
        }
        for(int i=1;i<=n;i++){
            insert(i,i,chafen,sum[i]);
        }
        for(int i=1;i<=k;i++){
            int left=scanner.nextInt();
            int right=scanner.nextInt();
            int num=scanner.nextInt();
            insert(left,right,chafen,num);
        }
        for(int i=1;i<=n;i++){
            sum[i]=sum[i-1]+chafen[i];
        }
        int i;
        for(i=1;i<n;i++){
            System.out.print(sum[i]+" ");
        }
        System.out.print(sum[i]);
    }
    public static void insert(int l,int r,int[] chafen,int sum){
        chafen[l]+=sum;
        chafen[r+1]-=sum;
    }
}
