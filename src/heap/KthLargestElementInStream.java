package heap;

import java.util.PriorityQueue;


public class KthLargestElementInStream {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    int K = 0;

    public KthLargestElementInStream(int k, int[]nums) {
        K = k;
        for (int num: nums)
            priorityQueue.offer(num);
    }

    public int add(int val) {
            priorityQueue.add(val);
            while(priorityQueue.size() >K)
                priorityQueue.poll();
            return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int [] nums = new int[]{10,3,5,2,1};
        int k=2;
        KthLargestElementInStream stream = new KthLargestElementInStream(2,nums);

        System.out.println(stream.add(20));
        System.out.println(stream.add(11));
        System.out.println(stream.add(22));
        System.out.println(stream.add(13));

    }

    }


