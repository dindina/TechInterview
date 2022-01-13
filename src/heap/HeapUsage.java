package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import com.sun.xml.internal.xsom.XSUnionSimpleType;


public class HeapUsage {

    public static void main(String[] args) {
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        minPriorityQueue.offer(11);
        minPriorityQueue.offer(3);
        minPriorityQueue.offer(5);
        minPriorityQueue.offer(1);
        System.out.println(minPriorityQueue);

        maxPriorityQueue.offer(11);
        maxPriorityQueue.offer(3);
        maxPriorityQueue.offer(5);
        maxPriorityQueue.offer(1);
        System.out.println(maxPriorityQueue);


    }
}
