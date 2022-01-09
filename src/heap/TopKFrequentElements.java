package heap;

import java.util.List;
import java.util.PriorityQueue;


public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] nums = new int[] { 5, 6, -7, 8, 9, -1 };
        List<Integer> result = TopKFrequentElements.find(nums, 3);
        System.out.println("Here are the top K numbers: " + result);
    }

    private static List<Integer> find(final int[] nums, final int i) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1,n2)-> n1-n2);
        return null;
    }

}
