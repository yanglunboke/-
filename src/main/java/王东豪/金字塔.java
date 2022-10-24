package 王东豪;

import java.util.Scanner;

public class 金字塔 {
    public static void main(String[] args) {
        int[] ints=new int[]{1,2,3,9,4,5};
        int[] ints1=new int[ints.length];
        int[] ints2=new int[ints.length];
        int max=-11111,index=0;
        for(int i=0;i< ints.length;i++){
            if(ints[i]>max){
                max=ints[i];
                index=i;
            }
        }
        for(int j=0;j<index;j++){
            ints1[j]=ints[j];
        }
        for(int j=index,m=0;j<ints.length;j++,m++){
            ints2[m]=ints[j];
        }
        for(int i=0;i<ints.length&&ints1[i]!=0;i++){
            System.out.print(ints1[i]+" ");
        }
        System.out.println();
        for(int i=0;i<ints.length&&ints2[i]!=0;i++){
            System.out.print(ints2[i]+" ");
        }
    }
}

