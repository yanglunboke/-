package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[] nums=new int[]{0,0,0,0};
        solu s = new solu();
        List<List<Integer>> lists = s.fourSum(nums, 0);
    }
}

class solu{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-4;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-3;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int m=j+1;
                int n=nums.length-1;
                while(m<n){
                    int sum=nums[i]+nums[j]+nums[m]+nums[n];
                    if(sum==target){
                        list.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        while(m<n&&nums[m]==nums[m+1]){
                            m++;
                        }
                        while(m<n&&nums[n]==nums[n-1]){
                            n--;
                        }
                        m++;
                        n--;
                    }else if(sum>target){
                        n--;
                    }else if(sum<target){
                        m++;
                    }
                }
            }
        }
        return list;
    }
}
