package practice;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int [] nums = new int[] {1,3,2,100,4};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max=0;
        for(int i:nums)
        {
            set.add(i);
        }

        for(int i :set)
        {
            int prev = i-1;
            int curr =i;
            if(!set.contains(prev))
            {
                int count=0;
                while(set.contains(curr++))
                    count++;
                max = Math.max(count,max);
            }
        }

        return max;
    }



}
