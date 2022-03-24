package linkedlist;

public class DeleteNthNodeFromList {

    public static void main(String[] args) {
        ListNode node  = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode newlist = deleteFromList(node,2);
        newlist.printList();
    }

    private static ListNode deleteFromList(ListNode node , int n) {
        ListNode ptr1 = node;
        ListNode ptr2 = node;

        for(int i=0 ;i <n+1 ;i++)
        {
            ptr1 = ptr1.next;
        }
        System.out.println(ptr1.val);

        if(ptr1 == null)
            return node.next;

        while(ptr1 !=null)
        {
            ptr1= ptr1.next;
            ptr2= ptr2.next;

        }
        ptr2.next = ptr2.next.next;

        return node;
    }
}
