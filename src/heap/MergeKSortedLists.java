package heap;

import linkedlist.ListNode;

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

        ListNode result = new MergeKSortedLists().mergeKLists(lists);
        result.printList();
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode current = result;

        int k = lists.length; // total lists

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1,l2) -> l1.val-l2.val);
        for(int i=0; i < k ; i++) {
            if(lists[i] !=null) {
                minHeap.offer(lists[i]);

            }
        }
        while(!minHeap.isEmpty())
        {
            ListNode node = minHeap.poll();
            current.next = new ListNode(node.val);
            current = current.next;
            node = node.next; // this takes care of selecting the node to move

            if(node !=null) // if the list is null it reached the end
            {
                minHeap.offer(node);
            }

        }
        return result.next;
    }
}
