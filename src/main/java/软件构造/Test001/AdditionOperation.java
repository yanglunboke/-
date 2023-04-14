package 软件构造.Test001;

public class AdditionOperation extends BinaryOperation_3_2 {
    AdditionOperation(){
        generateBinaryOperation('+');
    }
    @Override
    boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER;
    }

    @Override
    int calculate(int left, int right) {
        return left+right;
    }
}
