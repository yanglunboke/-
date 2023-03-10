package 软件构造;

public class ExerciseSheet_3_2_5 {
    private static final short COLUMN_NUMBER=5;
    public void formattedDisplay (Exercise_3_2_4 ex,int columns){
        int i=1;
        while(ex.hasNext()){
            BinaryOperation_3_2 next = ex.next();
            System.out.print(i+". "+next+" ");
            i++;
            if(i==columns+1){
                System.out.println();
                i=1;
            }
        }
    }
    public void formattedDisplay(Exercise_3_2_4 ex){
        formattedDisplay(ex,COLUMN_NUMBER);
    }
    private static void print(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        ExerciseSheet_3_2_5 sheet=new ExerciseSheet_3_2_5();
        Exercise_3_2_4 exercise=new Exercise_3_2_4();
        //exercise.generateAdditionExercise(28);
        exercise.generateBinaryExercise(28);
        System.out.println("---- generate and display add exercises ----");
        sheet.formattedDisplay(exercise,4);
    }
}
