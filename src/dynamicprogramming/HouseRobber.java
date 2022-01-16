package dynamicprogramming;

/*
ou are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

    public static int rob(int[] nums) {

        // solve using dp array
        int [] dp = new int[nums.length+1];
        //System.out.println(nums.length);
        // initialize dp
        dp[0]=0;
        dp[1] = nums[0];

        for(int i=1 ; i < nums.length ; i++)
        {
            dp[i+1] = Math.max(dp[i] , dp[i-1] + nums[i]);
        }
        System.out.println(dp);
        return dp[nums.length];

    }

    public static void main(String[] args) {

        int [] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));

        int [] nums1 = new int[]{11,2,3,10};
        System.out.println(rob(nums1));

    }

}
