package 软件构造;

public class MulOperation extends BinaryOperation_3_2{
    MulOperation(){
        generateBinaryOperation('×');
    }
    @Override
    boolean checkingCalculation(int anInteger) {
        return anInteger<=UPPER;
    }

    @Override
    int calculate(int left, int right) {
        return left*right;
    }
}
