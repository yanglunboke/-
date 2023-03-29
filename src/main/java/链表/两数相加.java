package 链表;

import java.util.List;

public class 两数相加 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(5);
        ListNode l11=l1;
        ListNode l22=l2;
        l11.next=new ListNode(4);
        l11=l11.next;
        l11.next=new ListNode(3);
        l22.next=new ListNode(6);
        l22=l22.next;
        l22.next=new ListNode(4);
        ListNode listNode = nums(l1, l2);
    }

    public static ListNode nums(ListNode l1,ListNode l2){
        ListNode node = new ListNode(0);
        ListNode now=node;
        int num=0,sum=0;
        while(l1!=null||l2!=null||num==1){
            int x= l1==null?0:l1.val;
            int y= l2==null?0:l2.val;
            sum=x+y+num;
            num=sum/10;
            sum=sum%10;
            now.next=new ListNode(sum);
            now=now.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return node.next;
    }

}
