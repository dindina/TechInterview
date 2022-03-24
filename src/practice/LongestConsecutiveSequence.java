package practice;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int [] nums = new int[] {1,3,2,100,5,4};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int result=0;
        if(nums.length ==0) return 0;
        if(nums.length==1) return 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums)
        {
            set.add(i);
        }
        System.out.println(set);

        for(Integer num : set)
        {
            int prev = num -1;
            if(!set.contains(prev)) // this is the first of the sequence
            {
                int counter =0;
                while(set.contains(num++))
                    counter++;
                result = Math.max(counter,result);
            }

        }
        return result;
    }



}
