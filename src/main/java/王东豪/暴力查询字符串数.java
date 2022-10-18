package 王东豪;

import java.util.Scanner;

public class 暴力查询字符串数 {
    public static void main(String[] args) {
        int n,m;
        int num=0;
        String s,S;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        s=scanner.next();
        m=scanner.nextInt();
        S=scanner.next();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<m;i++){
            builder.append(S.charAt(i));
            if(builder.toString().equals(s)){
                num++;
            }
            for(int j=i+1;j<m;j++) {
                builder.append(S.charAt(j));
                if (builder.toString().equals(s)) {
                    num++;
                    break;
                }
                if(builder.length()>n){
                    break;
                }
            }
            builder.delete(0,builder.length());
        }
        System.out.println(num);
    }
}

