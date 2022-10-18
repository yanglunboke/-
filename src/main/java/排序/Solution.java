package 排序;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        List<Integer> res=new ArrayList<>();
        List<Integer> bool=new ArrayList<>();
        dfs(0,n,res,bool);
    }
    private static void dfs(int r,int n,List<Integer> res,List<Integer> bool){
        if(r==n){
            for (int i=0;i<n;i++){
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
            return;
        }
        if(r<n){
            for(int i=1;i<=n;i++){
                if(!bool.contains(i)){
                    res.add(i);
                    bool.add(i);
                    dfs(r+1,n,res,bool);
                    res.remove((Integer) i);
                    bool.remove((Integer) i);
                }
            }
        }
    }
}