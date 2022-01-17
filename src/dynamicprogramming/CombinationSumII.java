package dynamicprogramming;

import java.util.Arrays;


/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.



Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0

 */
public class CombinationSumII {

    public static int combinationSum4(int[] nums, int target) {

        int dp[] = new int[target+1];
        dp[0]=1;
        for(int i=1 ; i <= target ; i++) {
            for (int j = 0; j < nums.length; j++)
            {
                if(i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }

            }
        }
        return dp[target];


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int target = 5;
        System.out.println(combinationSum4(nums,target));

    }

}
