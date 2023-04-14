package 软件构造.Test001;

public class SubstractOperation extends BinaryOperation_3_2{
    SubstractOperation(){
        generateBinaryOperation('-');
    }
    @Override
    boolean checkingCalculation(int anInteger) {
        return anInteger<=UPPER&&anInteger>=0;
    }

    @Override
    int calculate(int left, int right) {
        return left-right;
    }
}
