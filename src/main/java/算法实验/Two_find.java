package 算法实验;

import java.util.Arrays;

public class Two_find {
    //大于等于x的第一个数(这里属于区间的右边即>=x的数->第一个是大于等于x的第一个数)
    public int two_find01(int[] array,int x){
        int l=0,r=array.length-1;
        while(l<r){
            int mid=l+r>>1;
            if(array[mid]>=x){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        if(array[l]!=x){
            return -1;
        }else {
            return l;
        }
    }

    //大于等于x的最后一个数(这里属于区间的左边即<=等于x的数->最后一个是小于等于x的最后一个数)
    public int two_find02(int[] array,int x){
        int l=0,r=array.length-1;
        while(l<r){
            int mid=l+r+1>>1;
            if(array[mid]<=x){
                l=mid;
            }else {
                r=mid-1;
            }
        }
        if(array[l]!=x){
            return -1;
        }else {
            return l;
        }
    }
}


