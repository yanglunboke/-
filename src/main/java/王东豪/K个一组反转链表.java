package 王东豪;

import java.util.Scanner;

public class K个一组反转链表 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k=sc.nextInt();
        //初始化链表
        ListNode head = new ListNode(1);
        ListNode now = head;
        for(int i=2;i<=5;i++) {
            now.next = new ListNode(i);
            now = now.next;
        }

        ListNode pre = reverseKGroup(head, k);

        //输出测试
        while(pre!=null){
            System.out.print("<"+pre.val+">");
            pre=pre.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head,int k){
        ListNode hair=new ListNode(0);
        hair.next=head;
        ListNode pre=hair;

        while(head!=null){
            ListNode tail=pre;
            for(int i=0;i<k;i++){
                tail=tail.next;
                if(tail==null){
                    return hair.next;
                }
            }
            ListNode nex=tail.next;
            ListNode[] reverse=myReverse(head,tail);
            head=reverse[0];
            tail=reverse[1];

            pre.next=head;
            tail.next=nex;
            pre=tail;
            head=tail.next;
        }
        return hair.next;
    }

    public static ListNode[] myReverse(ListNode head,ListNode tail){
        ListNode prev=null;
        ListNode next;
        ListNode p=head;
        while(prev!=tail){
            next=p.next;
            p.next=prev;
            prev=p;
            p=next;
        }
        return new ListNode[]{tail,head};
    }
}
