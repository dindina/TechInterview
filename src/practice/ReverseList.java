package practice;

import linkedlist.ListNode;

public class ReverseList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.printList();
        ListNode reverse = reverseList(node);
        reverse.printList();

    }

    public static ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr !=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }
        return prev;
    }
}
