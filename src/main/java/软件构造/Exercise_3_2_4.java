package 软件构造;

import java.util.ArrayList;
import java.util.Random;

public class Exercise_3_2_4 {
    private ArrayList<BinaryOperation_3_2> operationList=new ArrayList<BinaryOperation_3_2>();
    private int current=0;
    public void generateAdditionExercise(int operationCount){
        BinaryOperation_3_2 bop;
        for(int i=0;i<operationCount;i++){
            bop=new AdditionOperation();
            operationList.add(bop);
        }
    }
    public void generateSubstractExercise(int operationCount){
        BinaryOperation_3_2 bop;
        for(int i=0;i<operationCount;i++){
            bop=new SubstractOperation();
            operationList.add(bop);
        }
    }
    public void generateBinaryExercise(int operationCount){
        BinaryOperation_3_2 bop;
        while(operationCount>0){
            bop=generateOperation();
            operationCount--;
            operationList.add(bop);
        }
    }
    private BinaryOperation_3_2 generateOperation(){
        Random random=new Random();
        int opValue=random.nextInt(2);
        if(opValue==1){
            return new AdditionOperation();
        }
        return new SubstractOperation();
    }
    public boolean hasNext(){
        return current<=operationList.size()-1;
    }
    public BinaryOperation_3_2 next(){
        return operationList.get(current++);
    }
}
