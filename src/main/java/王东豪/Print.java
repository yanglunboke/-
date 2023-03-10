package 王东豪;

import java.util.Scanner;

public class Print {
    public static void main(String[] args) {
        int m;
        Scanner scanner = new Scanner(System.in);
        m=scanner.nextInt();
        for(int i=1;i<=m;i++)
        {
            int s=i%10;
            if(s!=2&&s!=7)
            {
                System.out.print(""+i+" ");
            }
        }
    }
}
