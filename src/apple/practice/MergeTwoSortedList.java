package apple.practice;

import linkedlist.ListNode;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode mergedList = head;


        while(list1!=null && list2!=null)
        {
            int val1 = list1 !=null ? list1.val : 0;
            int val2 = list2 !=null ? list2.val : 0;
            if(val1 <= val2) {
                mergedList.next = new ListNode(val1);
                if( list1!=null) list1 = list1.next;
            }
            else {
                mergedList.next = new ListNode(val2);
                if( list2!=null) list2 = list2.next;
            }
            mergedList = mergedList.next;
        }

        mergedList.next = list1 ==null ? list2 :list1;

        return head.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);


        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode merged = new MergeTwoSortedList().mergeTwoLists(node1,node2);
        merged.printList();

    }


}
