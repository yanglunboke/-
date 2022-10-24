package 王东豪;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class 反转链表 {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode now=node;
        for(int i=1;i<=5;i++) {
            now.next = new ListNode(i);
            now = now.next;
        }

        int k=4;
        node=node.next;
        ListNode pre=null;
        ListNode p;
        while(k--!=0){
            p=node.next;
            node.next=pre;
            pre=node;
            node=p;
        }

        while(pre!=null){
            System.out.print("<"+pre.val+">");
            pre=pre.next;
        }

    }

}
