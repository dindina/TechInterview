package practice;

import linkedlist.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(5);


        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(7);


        ListNode node3 = new ListNode(5);
        node3.next = new ListNode(7);
        node3.next.next = new ListNode(9);

        ListNode[] lists = new ListNode[3];
        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;

        ListNode result = new heap.MergeKSortedLists().mergeKLists(lists);
        result.printList();
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        // logic to use min heap and poll one by one
        PriorityQueue<ListNode> queue = new PriorityQueue<>((l1,l2)->l1.val-l2.val);
        for(ListNode node : lists)
        {
            queue.offer(node); // add all the heads to the queue
        }

        while(!queue.isEmpty())
        {
            ListNode node = queue.poll();

            ListNode temp = new ListNode(node.val);
            curr.next = temp;
            curr = curr.next;

            node = node.next; // this makes sure the list node moves
            if(node!=null)
                queue.offer(node);


        }
        return head.next;
    }
}
