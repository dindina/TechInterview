package heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;


public class HeapUsage {

    public static void main(String[] args) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        minheap.offer(11);
        minheap.offer(31);
        minheap.offer(-5);
        minheap.offer(1);
        printPriorityQueue(minheap);

        maxheap.offer(3);
        maxheap.offer(31);
        maxheap.offer(51);
        maxheap.offer(1);
        printPriorityQueue(maxheap);

        PriorityQueue<Integer[]> pq = new  PriorityQueue<>((a, b) -> {
            System.out.println("a[0]" +a[0]);
            System.out.println("b[0]" +b[0]);
            System.out.println("a[1]" +a[1]);
            System.out.println("b[1]" +b[1]);
            if (a[0] == b[0]) return b[1] - a[1];
            else return b[0] - a[0];
        });
        Integer [] nums1 = new Integer[]{5,6,0,0};
        System.out.println(nums1);
        Integer [] nums2 = new Integer[]{1,4,1,0};
        System.out.println(nums2);
        pq.offer(nums1);
        pq.offer(nums2);

        System.out.println("pq " + pq);

    }

    private static void printPriorityQueue(final PriorityQueue<Integer> priorityQueue) {


        System.out.println("polling order");
        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.poll());

    }
}
