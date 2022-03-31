package apple.practice;

import linkedlist.ListNode;
import org.w3c.dom.NodeList;

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

    public static ListNode  reverseList(ListNode node)
    {
        ListNode curr = node;
        ListNode prev = null;
        ListNode next;
        while(curr !=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
