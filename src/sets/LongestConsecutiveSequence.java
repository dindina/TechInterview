package sets;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int [] nums = new int[] {1,3,2};

        System.out.println(findLengthOfLongestConsecutiveSequence(nums));

    }

    public static int findLengthOfLongestConsecutiveSequence(int[] nums)
    {
        if(nums.length==0) return 0;
        if(nums.length ==1) return 1;

        // put  all the array into set
        System.out.println(Arrays.asList(nums));
        HashSet<Integer> set = new HashSet<>();
        for(int in : nums)
            set.add(in);
        System.out.println("set " + set);
        int max = 0;
        for(Integer num : set)
        {
            int prev = num-1;
            int next = num+1;

            int count=1;
            if(!set.contains(prev)) // start counting when this can be the last in the seq
            // start counting when there is no other lesser no
            {
                while(set.contains(next)) {
                    System.out.println("next " + next);
                    count++;
                    next++;
                }
                max = Math.max(count,max);
            }
        }

        return max;

    }
}
