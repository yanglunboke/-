package 链表;

import java.util.List;

public class 翻转链表 {
    public static void main(String[] args) {
        ListNode list = new ListNode(2);
        ListNode now=list;
        now.next=new ListNode(3);
        now=now.next;
        now.next=new ListNode(4);
        ListNode newList = reverseList(list);
        while(newList!=null){
            System.out.print(newList.val+" ");
            newList=newList.next;
        }
    }
    public static ListNode reverseList(ListNode head){
        ListNode pre=head;
        ListNode newList=null;
        while(pre!=null){
            ListNode next=pre.next;
            pre.next=newList;
            newList=pre;
            pre=next;
        }
        return newList;
    }
}
