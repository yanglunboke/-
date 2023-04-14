package 软件构造.最终2;

import static 软件构造.最终2.BinaryOperation.UPPER;

public class DivOperation extends BinaryOperation{
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
