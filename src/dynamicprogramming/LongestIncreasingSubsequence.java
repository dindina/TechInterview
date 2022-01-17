package dynamicprogramming;

import java.util.Arrays;


/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */
public class LongestIncreasingSubsequence {


    public static int lengthOfLIS(int[] nums) {

        int dp[] = new int[nums.length+1];
        Arrays.fill(dp,1);
        dp[0]=0;
        int result=0;
        for(int i=1 ; i < nums.length; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(result, dp[i]);
        }


        return result;

    }

    public static void main(String[] args) {
        int [] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));

        nums = new int[]{1,2,3,4};
        System.out.println(lengthOfLIS(nums));
    }
}
