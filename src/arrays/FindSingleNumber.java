package arrays;

/**
 * https://leetcode.com/problems/single-number/description/
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 */
public class FindSingleNumber {
    public static void main(String[] args) {
     int[] nums = new int[]{1,2,3,4,4,3,2};
     System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {

        int ans=nums[0];
        int i=0;
        while(i<nums.length-1){
            ans=ans^nums[i+1];
            i++;
        }
        return ans;

    }

}
