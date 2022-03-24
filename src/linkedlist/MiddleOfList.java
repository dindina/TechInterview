package linkedlist;

public class MiddleOfList {
    public static void main(String[] args) {
        ListNode node  = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        //node.next.next.next = new ListNode(4);
        //node.next.next.next.next = new ListNode(5);
        System.out.println(middle(node).val);
    }

    private static ListNode middle(ListNode node) {
        ListNode fast=node;
        ListNode slow=node;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
