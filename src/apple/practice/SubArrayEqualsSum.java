package apple.practice;

import java.util.HashMap;

/*
https://leetcode.com/problems/subarray-sum-equals-k/
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
Input: nums = [1,1,1], k = 2
Output: 2
 */
public class SubArrayEqualsSum {

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1); // used for the first count
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(map);
        return count;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{0,0,0,0,0,0,0,0,0,0};
        //int sum=0;
        int[] nums = new int[]{1,2,3};
        int sum=3;

        System.out.println(new SubArrayEqualsSum().subarraySum(nums,sum));
    }
}
