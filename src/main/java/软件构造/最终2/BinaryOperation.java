package 软件构造.最终2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public abstract class BinaryOperation implements Serializable {
    static final int UPPER=100;
    static final int LOWER=0;
    private int left_operand=0,right_operand=0;
    private char operator='+';
    private int value=0;

    public void insert(String left, String right){
        //新增：insert通过调用这个方法可以直接插入算式
        left_operand = Integer.valueOf(left);
        right_operand = Integer.valueOf(right);
        value = calculate(left_operand, right_operand);
    }
    public void insert(int left, int right){
        //新增：int参数的insert
        left_operand = left;
        right_operand = right;
        value = calculate(left_operand, right_operand);
    }
    //重载public String toString
    public String toString(){
        String s;
        String Charop = String.valueOf(operator);
        s = left_operand+Charop+right_operand+"=";
        return s;
    }


    // getXX 返回需要访问的数字和符号
    public char getOperator(){
        return operator;
    }
    public int getleft_operand(){
        return left_operand;
    }
    public int getright_operand(){
        return right_operand;
    }
    public int getvalue() {
        return value;
    }
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

    public boolean equals(ArrayList<BinaryOperation> list){
        Iterator<BinaryOperation> iterator = list.iterator();
        boolean is=false;
        while(iterator.hasNext()){
            BinaryOperation next = iterator.next();
            if(next.getLeft_operand()==this.left_operand&&next.getRight_operand()==this.right_operand
                    &&next.getOperator()==this.operator){
                is=true;
            }
        }
        return is;
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
