package 软件构造;

public class BinaryOperationTester {
    public static void main(String[] args) {
        BinaryOperation_3_2 bop;
        for(int i=0;i<100;i++){
            bop=new AdditionOperation();
            System.out.println(bop);
        }
    }
}
