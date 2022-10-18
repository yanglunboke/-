package 搜索算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String digits;
        Scanner scanner = new Scanner(System.in);
        digits=scanner.next();

        List<String> res=new ArrayList<>();
        StringBuilder path=new StringBuilder();
        HashMap<Character,String> map=new HashMap<Character,String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};

        dfs(0,digits.length(),res,path,digits,map);
        System.out.println(res);
    }
    private static void dfs(int n,int r,List<String> res,StringBuilder path,String digits,HashMap<Character,String> map){
        if(n==r){
            res.add(path.toString());
            return;
        }
        if(n<r){
            char ch=digits.charAt(n);
            String st=map.get(ch);
            for(int i=0;i<st.length();i++){
                path.append(st.charAt(i));
                dfs(n+1,r,res,path,digits,map);
                path.deleteCharAt(path.length()-1);
            }
        }
    }
}
