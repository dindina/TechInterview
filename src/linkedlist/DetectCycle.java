package linkedlist;

public class DetectCycle {

    public static void main(String[] args) {
        ListNode node  = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = node;
        //node.next.next.next.next = new ListNode(5);
        //System.out.println(middle(node).val);
        System.out.println(detectCycle(node));
    }

    private static boolean detectCycle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while(fast !=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }


}
