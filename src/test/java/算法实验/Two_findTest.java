package 算法实验;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Two_findTest {
    public static void main(String[] args) {
        int[] array = {2,4,6,8,8,9,13,10};
        System.out.println(Arrays.toString(array));
        System.out.println(new Two_find().two_find02(array,8));
    }
}