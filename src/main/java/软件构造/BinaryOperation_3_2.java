package 软件构造;

import java.util.Random;

abstract class BinaryOperation_3_2 {
    static final int UPPER=100;
    private int left_operand=0,right_operand=0;
    private char operator='+';
    private int value=0;
    protected void generateBinaryOperation(char anOperator){
        int left,right,result;
        Random random=new Random();
        left=random.nextInt(UPPER+1);
        do {
            right=random.nextInt(UPPER+1);
            result=calculate(left,right);
        }while(!(checkingCalculation(result)));
        left_operand=left;
        right_operand=right;
        operator=anOperator;
        value=result;
    }
    abstract boolean checkingCalculation(int anInteger);
    abstract int calculate(int left,int right);

    public boolean equals(){
        return false;
    }

    @Override
    public String toString() {
        return left_operand+""+operator+""+right_operand+"="+value;
    }
    public String anString(){
        return left_operand+""+operator+""+right_operand+"=";
    }
    public String fullString(){
        return left_operand+""+operator+""+right_operand;
    }
}
