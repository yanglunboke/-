package 软件构造;

import com.sun.org.apache.xpath.internal.operations.Div;

import java.util.Random;

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
