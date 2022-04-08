package linkedlist;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(13);
        Node node3 = new Node(15);
        Node node4 = new Node(17);

        node1.next = node2;
        node1.random = node4;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random=node1;
        node4.random = node2;
        Node curr = node1;
        while(curr!=null)
        {
            System.out.println(curr.val + "," + curr.random.val) ;
            curr = curr.next;
        }
        System.out.println("--------------");
        Node clone = new CopyListWithRandomPointer().copyRandomList(node1);
        while(clone!=null)
        {
            System.out.println(clone.val + "," + clone.random.val) ;
            clone = clone.next;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node,Node> map = new HashMap<>();
        Node curr = head;
        while(curr!=null)
        {
            map.put(curr,new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr!=null)
        {
            map.get(curr).random = map.get(curr.random);
            map.get(curr).next = map.get(curr.next);
            curr=curr.next;
        }

        return map.get(head);
    }
}