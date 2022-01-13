package linkedlist;

public class ReverseSubList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        result.printList();;
    }

    private static ListNode reverse( ListNode head, final int val1, final int val2) {

        if(head == null)
            return null;
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        // traverse to the element val1
        while(current!=null && current.val!= val1)
        {
            prev = current;
            current = current.next;
        }

        ListNode lastNodeOfFirstPart = prev;
        ListNode lastNodeOfSubList = current;
        // no we have reached node . we need to traverse till val2

        while(current!= null && current.val!= val2-val1+1)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (lastNodeOfFirstPart != null)
            lastNodeOfFirstPart.next = prev; // 'previous' is now the first node of the sub-list
        else // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
            head = prev;

        lastNodeOfSubList.next = current;
        return head;

    }

}
