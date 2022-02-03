package linkedlist;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {
    class Node{

        int key;
        int value;
        Node next;
        Node prev;
    }
    // add next to the head
    public void addNode(Node node)
    {
        Node temp = new Node();
        temp.key=node.key;
        temp.value=node.value;
        //set the pointers for the new node
        temp.prev = head;
        temp.next = head.next;

        //set the pointers for the head node
        head.next = temp;
        head.next.prev = temp;

    }

    public void removeNode(Node node)
    {
        if(node !=null) {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev= prev;

        }
    }

    public void moveToHead(Node node)
    {
        removeNode(node);
        addNode(node);
    }

    public Node popTail()
    {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    int capacity;
    int size;
    Map<Integer,Node> cacheMap ;
    final Node head; // does not store any data , it is fixed node
    final Node tail; // does not store any data , it is fixed node
    // no need to maintain the head and tail . it is fixed always

    public LRUCache(int capacity)
    {
        this.capacity=capacity;
        this.size=0;
        cacheMap = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next=  tail;
        tail.prev = head;

    }

    public int get(int key)
    {
        Node node  = cacheMap.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put (int key,int value)
    {
        Node node = cacheMap.get(key);
        if(node == null)
        {
            Node newNode = new Node();
            node.key = key;
            node.value = value;

            if(size>= capacity) // need to remove one element and then put this
            {
                Node pop = popTail();
                cacheMap.remove(pop.key);
                size--;
            }
            else
            {
                cacheMap.put(key,newNode);
                addNode(node);
                size++;
            }

        }
        else {
            node.value= value;
            moveToHead(node);
        }
    }






}
