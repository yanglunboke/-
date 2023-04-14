package 软件构造.Test001;

public class DivOperation extends BinaryOperation_3_2{
    DivOperation(){
        generateBinaryOperation('÷');
    }
    @Override
    boolean checkingCalculation(int anInteger) {
        return anInteger<=UPPER;
    }

    @Override
    int calculate(int left, int right) {
        return left/right;
    }
}
