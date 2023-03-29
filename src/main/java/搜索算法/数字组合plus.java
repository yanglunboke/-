package 搜索算法;

import 王东豪.Cy.A;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class 数字组合plus {
    public static void main(String[] args) {
        int n,r;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        r=sc.nextInt();
        ArrayList<Integer> isExist = new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        dfs(n,r,0,isExist,list);
    }
    public static void dfs(int n,int r,int e,ArrayList<Integer> isExist,ArrayList<Integer> list){

        if(e==r){
            int i;
            for(i=0;i<r-1;i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println(list.get(i));
            return;
        }
        if(e<r){
            for(int i=n;i>0;i--){
                if(!isExist.contains(i)){
                    list.add(i);
                    isExist.add(i);
                    dfs(n,r,e+1,isExist,list);
                    list.remove((Integer) i);
                    isExist.remove((Integer) i);
                }
            }
        }
    }
}
