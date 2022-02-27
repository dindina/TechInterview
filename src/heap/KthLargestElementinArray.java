package heap;

import java.util.PriorityQueue;

public class KthLargestElementinArray {
    public static void main(String[] args) {
        int [] nums = new int[]{3,2,1,5,6,4};
        System.out.println(new KthLargestElementinArray().findK(nums,2));
    }

    private int findK(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<nums.length ;i++)
        {
                queue.offer(nums[i]);
                if(queue.size()>k)
                    queue.poll();
        }

        System.out.println("queue2 is " + queue);

        return queue.peek();
    }
}
