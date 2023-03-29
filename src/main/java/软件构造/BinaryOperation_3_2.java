package 软件构造;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

//算式抽象基类
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
            if(anOperator=='÷'){
                while(!Divchecking(left,right)){
                    left=random.nextInt(UPPER+1);
                    right=random.nextInt(UPPER+1);
                }
            }
            if(anOperator=='×'){
                while(!Mulchecking(left,right)){
                    left=random.nextInt(UPPER+1);
                    right=random.nextInt(UPPER+1);
                }
            }
            result=calculate(left,right);
        }while(!(checkingCalculation(result)));
        left_operand=left;
        right_operand=right;
        operator=anOperator;
        value=result;
    }

    boolean Divchecking(int left,int right){
        if(right==0){
            return false;
        }else if(left%right!=0){
            return false;
        }else if(left<right){
            return false;
        }else if(right==1){
            return false;
        }else if(left==right){
            return false;
        }
        else {
            return true;
        }
    }
    boolean Mulchecking(int left,int right){
        if(left==1||right==1||left==0||right==0){
            return false;
        }else {
            return true;
        }
    }
    abstract boolean checkingCalculation(int anInteger);
    abstract int calculate(int left,int right);

    public boolean equals(ArrayList<BinaryOperation_3_2> list){
        Iterator<BinaryOperation_3_2> iterator = list.iterator();
        boolean is=false;
        while(iterator.hasNext()){
            BinaryOperation_3_2 next = iterator.next();
            if(next.getLeft_operand()==this.left_operand&&next.getRight_operand()==this.right_operand
            &&next.getOperator()==this.operator){
                is=true;
            }
        }
        return is;
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

    public int getLeft_operand() {
        return left_operand;
    }

    public void setLeft_operand(int left_operand) {
        this.left_operand = left_operand;
    }

    public int getRight_operand() {
        return right_operand;
    }

    public void setRight_operand(int right_operand) {
        this.right_operand = right_operand;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
