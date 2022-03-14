package apple.practice;

import linkedlist.ListNode;

import java.util.List;

public class AddTwoNumbersInList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode sum = head;
        int carry=0;

        while(l1!=null || l2!=null)
        {
            int val1= l1 !=null ? l1.val :0;
            int val2= l2 !=null ? l2.val :0;
            int newval = val1+val2+carry;
            carry = newval/10;
            sum.next = new ListNode(newval%10);
            sum = sum.next;

            if(l1 !=null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }

        if(carry >0)
        {
            sum.next = new ListNode(carry);
        }

        return head.next; // first node was set to zero
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.printList();

        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(6);
        node1.next.next = new ListNode(4);
        node1.printList();
        ListNode sum = new AddTwoNumbersInList().addTwoNumbers(node, node1);
        sum.printList();
    }
}