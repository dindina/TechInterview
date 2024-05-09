package practice;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
public class MinimumSizeSubArrayWithGiveSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,8};
        int sum = 8;

        System.out.println(new MinimumSizeSubArrayWithGiveSum().sliding(nums,sum));

    }

    public int sliding(int[] nums, int sum)
    {
        int min=Integer.MAX_VALUE;
        int left=0;
        int windowsum=0;
        for(int right=0; right< nums.length; right++)
        {
            windowsum+=nums[right];
            System.out.println("windowsum " + windowsum);

            while(windowsum>=sum)
            {
                min = Math.min(min,right-left+1);
                windowsum-=nums[left++];
            }

        }
        if(min == Integer.MAX_VALUE) {
            System.out.println("inside");
            min = 0;
        }
        return min;
    }


}
