package 算法实验;

import java.util.Scanner;

public class 整数划分 {
    public static void main(String[] args) {
        System.out.println("请输入你希望被划分的数值n，以及最大划分数m");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(n+"被"+m+"的划分一共有"+f(n,m)+"个");
    }
    public static int f(int n, int m){
        if(n==1||m==1){	//n为1时和m为1时只有一种划分方法,也是回归条件
            return 1;
        }else if(n>m){	//n大于m时有两类方法，一类是使用m，一类是不使用m进行划分
            return f(n-m,m)+f(n,m-1);
        }else if(n<m){	//用来划分的m过大时，就是用n为最大值来划分n自己
            return f(n,n);
        }else{		//n==m时，也是两类划分，可用m也可不用m,用m时就只有一种划分
            return 1+f(n,n-1);
        }
    }
}
