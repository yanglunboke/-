package 王东豪;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class 包装机 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();
        int S= sc.nextInt();
        HashMap<Integer, StringBuilder> map = new HashMap<>();
        Deque<Character> flow=new LinkedList<>();
        for(int i=1;i<=N;i++){
            StringBuilder builder = new StringBuilder();
            map.put(i,builder);
            String s=sc.next();
            map.get(i).append(s);
        }
        StringBuilder SS = new StringBuilder();
        while(true){
            int num= sc.nextInt();
            if(flow.size()==S&&num!=0){
                SS.append(flow.pop());
            }
            if(flow.size()==0&&num==0){
                continue;
            }
            if(num==-1){
                break;
            }else if(num==0){
                SS.append(flow.pop());
            }else{
                if(map.get(num)==null){
                    continue;
                }
                flow.push(map.get(num).charAt(0));
                map.get(num).deleteCharAt(0);
            }
        }
        System.out.println(SS);
    }
}
