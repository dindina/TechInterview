package linkedlist;

public class ReverseList {
    public static void main(String[] args) {
        ListNode list = new ListNode(10);
        list.next = new ListNode(11);
        list.next.next = new ListNode((12));
        list.next.next.next = new ListNode((13));
        list.next.next.next.next = null;

        list.printList();
        System.out.println();
        System.out.println("after reverse");
        ListNode reverse = ReverseList.reverseList(list);
        System.out.println();
        //System.out.println("after reverse ");
        reverse.printList();
    }

    private static ListNode reverseList(ListNode current) {
        if(current == null)
            return null;

        ListNode previous = null;
        ListNode next = null;

        while(current!=null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;



    }
}
