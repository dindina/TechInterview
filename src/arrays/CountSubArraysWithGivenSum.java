package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 */
public class CountSubArraysWithGivenSum {

    public static void main(String[] args) {
        int [] nums = new int []{1,0,1,1};
        int k=2;

        System.out.println(new CountSubArraysWithGivenSum().subarraySum(nums,k));
    }

    public int subarraySum(int[] nums, int k) {
        int sum =0;

        int prefixsum =0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0 ; i< nums.length ; i++)
        {
            prefixsum += nums[i];
            int remaining = prefixsum-k;
            if(map.containsKey(remaining))
                sum += map.getOrDefault(remaining,0);

            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);

        }

        return sum;

    }
}
