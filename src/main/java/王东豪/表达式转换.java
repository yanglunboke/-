package 王东豪;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 表达式转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        char[] array = s.toCharArray();
        Deque<Character> nums=new LinkedList<>();
        Deque<Character> chars=new LinkedList<>();
        for(int i=0;i< array.length;i++){
            if(array[i]>='0'&&array[i]<='9'){
                nums.push(array[i]);
            }
            if(array[i]=='('){
                chars.push(array[i]);
            }
            if(array[i]=='+'||array[i]=='-'||array[i]=='*'||array[i]=='/'){
                if(chars.size()==0){
                    chars.push(array[i]);
                }else{
                    while(true){
                        char temp=chars.peek();
                        if(compare(array[i],temp)){
                            chars.push(array[i]);
                            break;
                        }else{
                            nums.push(chars.pop());
                            if(chars.size()==0){
                                chars.push(array[i]);
                                break;
                            }
                        }
                    }
                }
            }
            if(array[i]==')'){
                while(chars.peek()!='('){
                    nums.push(chars.pop());
                }
                chars.pop();
            }
        }
        while(chars.size()!=0){
            nums.push(chars.pop());
        }
        int num=nums.size();
        StringBuilder builder=new StringBuilder();
        for(int j=0;j<num;j++){
            builder.append(nums.pop());
        }
        int j;
        for(j=num-1;j>0;j--){
            System.out.print(builder.charAt(j)+" ");
        }
        System.out.print(builder.charAt(j));
    }
    public static boolean compare(char a,char b){
        //算术优先级a>b 返回true
        //加法
        if (a == '+'&&b == '+')
            return false;
        if (a == '+'&&b == '*')
            return false;
        if (a == '+'&&b == '(')
            return true;
        if (a == '+'&&b == '-')
            return false;
        if (a == '+'&&b == '/')
            return false;
        //减法
        if (a == '-'&&b == '+')
            return false;
        if (a == '-'&&b == '-')
            return false;
        if (a == '-'&&b == '*')
            return false;
        if (a == '-'&&b == '(')
            return true;
        if (a == '-'&&b == '/')
            return false;
        //乘法
        if (a == '*'&&b == '+')
            return true;
        if (a == '*'&&b == '-')
            return true;
        if (a == '*'&&b == '*')
            return false;
        if (a == '*'&&b == '(')
            return true;
        if (a == '*'&&b == '/')
            return false;
        //除法
        if (a == '/'&&b == '+')
            return true;
        if (a == '/'&&b == '-')
            return true;
        if (a == '/'&&b == '*')
            return false;
        if (a == '/'&&b == '(')
            return true;
        if (a == '/'&&b == '/')
            return false;
        return false;//语法要求必有返回值
    }
}
