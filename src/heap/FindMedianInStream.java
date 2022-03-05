package heap;

import java.util.PriorityQueue;

public class FindMedianInStream {
    PriorityQueue<Integer> minheap = null;
    PriorityQueue<Integer> maxheap = null;

    public FindMedianInStream() {

        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>((a,b)->b-a);

    }

    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if(maxheap.size() < minheap.size())
        {
            maxheap.offer(minheap.poll());
        }

    }

    public double findMedian() {

        //int double = maxheap.peek() +
        return 0;
    }
}
