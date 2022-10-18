package 排序;

public class 选择排序 {
    public static void main(String[] args) {
        int[] ints = new int[]{5,3,7,8,9,10,2,4,6,1};
        for(int i=0;i<9;i++){
            for(int j=i+1;j<10;j++){
                if (ints[i] > ints[j]) {
                    int a=ints[i];
                    ints[i]=ints[j];
                    ints[j]=a;
                }
            }
        }
        for (int i:ints) {
            System.out.print(i+" ");
        }
    }
}
