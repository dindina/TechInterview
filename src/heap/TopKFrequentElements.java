package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] nums = new int[] { 5,5,6,6, 6, -7, 8, 9, 9,9 };
        List<Integer> result = TopKFrequentElements.find(nums, 3);
        System.out.println("Here are the top K frequent numbers: " + result);
    }

    private static List<Integer> find(final int[] nums, final int k) {

        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for(int i=0; i < nums.length ; i++)
        {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>((n1,n2)-> n1.getValue()-n2.getValue());
        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet())
        {
            priorityQueue.offer(entry);
            if(priorityQueue.size()  > k) // maintaining the size of the queue . removing element
                priorityQueue.poll();
        }

        List<Integer> result = new ArrayList<>();

        while(!priorityQueue.isEmpty())
            result.add(priorityQueue.poll().getKey());
        return result;


    }

}
