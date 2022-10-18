package 排序;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] ints = new int[]{5,3,7,8,9,10,2,4,6,1};
        for(int i=0;i<9;i++){
            for(int j=0;j<9-i;j++){
                if(ints[j]>ints[j+1]){
                    int a=ints[j];
                    ints[j]=ints[j+1];
                    ints[j+1]=a;
                }
            }
        }
        for (int i:ints) {
            System.out.print(i+" ");
        }
    }
}
