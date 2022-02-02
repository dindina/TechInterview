package heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import com.sun.xml.internal.xsom.XSUnionSimpleType;


public class HeapUsage {

    public static void main(String[] args) {
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        minPriorityQueue.offer(11);
        minPriorityQueue.offer(31);
        minPriorityQueue.offer(-5);
        minPriorityQueue.offer(1);
        printPriorityQueue(minPriorityQueue);

        maxPriorityQueue.offer(3);
        maxPriorityQueue.offer(31);
        maxPriorityQueue.offer(51);
        maxPriorityQueue.offer(1);
        printPriorityQueue(maxPriorityQueue);


    }

    private static void printPriorityQueue(final PriorityQueue<Integer> priorityQueue) {


        System.out.println("polling order");
        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.poll());

    }
}
