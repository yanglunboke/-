package 软件构造.最终2;

public class MulOperation extends BinaryOperation{
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
