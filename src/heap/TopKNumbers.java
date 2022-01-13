package heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;


public class TopKNumbers {

    private static Integer findKthSmallestNumber(final int[] nums, final int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1,n2)->n2-n1);
        for(int i=0; i< k ; i++)
            priorityQueue.offer(nums[i]);

        for(int i=k ; i< nums.length ; i++)
        {
            if(nums[i] < priorityQueue.peek())
            {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }

        return priorityQueue.peek();
    }

    private static List<Integer> findKLargestNumbers(final int[] nums, final int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1,n2)->n1-n2);
        // insert k numbers into the priority queue
        for(int i=0;i<k;i++)
            priorityQueue.offer(nums[i]);

        for(int i=k;i<nums.length;i++) {
            if(nums[i] > priorityQueue.peek())
            {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }

        }
        return new ArrayList<>(priorityQueue);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{ 5,6,-7,8,9,-1 };
        List<Integer> result = TopKNumbers.findKLargestNumbers(nums, 3);
        System.out.println("Here are the top K numbers: " + result);

        System.out.println("1st smallest number " + TopKNumbers.findKthSmallestNumber(nums,1));
        System.out.println("2nd smallest number " + TopKNumbers.findKthSmallestNumber(nums,2));
        System.out.println("3rd smallest number " + TopKNumbers.findKthSmallestNumber(nums,3));


        /*result = TopKNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);
        */



        /*PriorityQueue<String> priorityQueue = new PriorityQueue<String>((n1,n2)->n2.length()-n1.length());
        priorityQueue.offer("dinesh");
        priorityQueue.offer("dinesh1");
        priorityQueue.offer("dinesh11");
        priorityQueue.offer("1");
        priorityQueue.offer("11111111111111");
        while(!priorityQueue.isEmpty())
            System.out.println(priorityQueue.poll());*/
        System.out.println("hello");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1,n2)->n1-n2);
        priorityQueue.offer(3);
        priorityQueue.offer(1);
        priorityQueue.offer(5);
        priorityQueue.offer(12);
        priorityQueue.offer(2);
        priorityQueue.offer(11);

        printPriorityQueue(priorityQueue);

    }

    private static void printPriorityQueue(final PriorityQueue<Integer> priorityQueue) {

        /*Iterator<Integer> iterator = priorityQueue.stream().iterator();
            while(iterator.hasNext())
            {
                System.out.println(iterator.next());
            }
        System.out.println("polling order");*/
        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.poll());

    }

}
