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
            if(bop.equals(operationList)){
                continue;
            }
            operationList.add(bop);
        }
    }
    public void generateSubstractExercise(int operationCount){
        BinaryOperation_3_2 bop;
        for(int i=0;i<operationCount;i++){
            bop=new SubstractOperation();
            if(bop.equals(operationList)){
                continue;
            }
            operationList.add(bop);
        }
    }
    public void generateDivExercise(int operationCount){
        BinaryOperation_3_2 bop;
        for(int i=0;i<operationCount;i++){
            bop=new DivOperation();
            if(bop.equals(operationList)){
                continue;
            }
            operationList.add(bop);
        }
    }
    public void generateMulExercise(int operationCount){
        BinaryOperation_3_2 bop;
        for(int i=0;i<operationCount;i++){
            bop=new MulOperation();
            if(bop.equals(operationList)){
                continue;
            }
            operationList.add(bop);
        }
    }
    public void generateBinaryExercise(int operationCount){
        BinaryOperation_3_2 bop;
        while(operationCount>0){
            bop=generateOperation();
            if(bop.equals(operationList)){
                continue;
            }
            operationList.add(bop);
            operationCount--;
        }
    }
    private BinaryOperation_3_2 generateOperation(){
        Random random=new Random();
        int opValue=random.nextInt(4);
        if(opValue==1){
            return new AdditionOperation();
        }else if(opValue==2){
            return new SubstractOperation();
        }else if(opValue==3){
            return new MulOperation();
        }else{
            return new DivOperation();
        }

    }
    public boolean hasNext(){
        return current<=operationList.size()-1;
    }
    public BinaryOperation_3_2 next(){
        return operationList.get(current++);
    }
}
