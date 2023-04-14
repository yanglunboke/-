package 算法实验;

import java.util.ArrayList;

import static java.util.Collections.swap;

public class ListSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        arrange(list,0,list.size()-1);
    }
    public static void arrange(ArrayList<Integer> list,int k,int m){
        if(k==m){
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }else {
            for(int j=k;j<=m;j++){
                swap(list,k,j);
                arrange(list,k+1,m);
                swap(list,k,j);
            }
        }
    }
}
//关键的就是arrange方法的else里面的内容，我的理解是（以求str[] = {“a”,”b”,”c”}的排列为例子）：
//
//用i从str[st]做一遍循环：
//
//每一次循环中，都要将str[i]与str[i]互相调换位置：第一次开始，”a”与自己换，这时候，递归调用arrange[str,st + 1, len]
//
//这是在求取str[str…len - 1]的排列即”b”,”c”的排列；
//
//第二次，”a”与”b”互相调换，递归调用arrange[str,str + 1, len]就是在求取{“a”,”c”}的排列。
//
//第三次，”a”与”c”互相调换，递归调用arrange[str, str + 1,len]就是在求取”{“b”,”a}的排列。
//
//下面再以”b”,”c”的排列求取为例：
//
//首先还是做循环，第一次，”b”与自己调换，这时候，调用arrange[str,st + 1,len], 就是求c的排列。呵呵，这时候终于到了函数递归调用的出口了: st = len - 1。输出”b” “c”;
//
//第二次，类似的，输出”c”,”b”;
//
//至此，”b” “c”的排列求取完毕。加上前面的a,就输出”a”“b”“c” “a”“c”“b”。
//
//类似的，就可以输出所有的排列了。
