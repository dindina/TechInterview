package graphs;

import java.util.HashSet;
import java.util.Set;


/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int [] nums = new int[] {100,4,200,1,3,2};

        System.out.println(findLengthOfLongestConsecutiveSequence(nums));

    }

    private static int findLengthOfLongestConsecutiveSequence(final int[] nums) {

        // use a set .
        // find the count of all the numbers which are greater than each of the element in the array
        // return the maximum size of this counts .

        // add all the array to a set.
        int maxCount  = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums)
            set.add(i);

        for(int i=0; i < nums.length ; i++)
        {
            int prev = nums[i]-1;
            int next = nums[i]+1;
            if(!set.contains(prev)) // if the prev number is there, then there is possibility of sequence
                // skipping if it is not there
                continue;
            else
            {
                int count = 1;
                while(set.contains(next++))
                    count ++;
                maxCount = Math.max(count,maxCount);
            }

        }
        return maxCount;
     }

}
