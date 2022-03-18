/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {

        int xor=nums[0];
        for(int i=1 ;i <nums.length;i++)
        {
            xor = i ^ xor ^ nums[i];
        }

        //System.out.println("xor " + xor);
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,2,2};
        System.out.println(new FindTheDuplicateNumber().findDuplicate(nums));
        //System.out.println(1^1);
        //System.out.println(5^3);
    }
}
