package heap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] nums = new int[] { 5, 6, -7, 8, 9, -1 };
        List<Integer> result = TopKFrequentElements.find(nums, 3);
        System.out.println("Here are the top K numbers: " + result);
    }

    private static List<Integer> find(final int[] nums, final int k) {

        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for(int i=0; i < nums.length ; i++)
        {
            frequencyMap.put(i, frequencyMap.getOrDefault(i,0)+1);
        }
        System.out.println(frequencyMap);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1,n2)-> n1-n2);


        return null;
    }

}
