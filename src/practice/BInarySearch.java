package practice;
/*
https://leetcode.com/problems/binary-search/
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

 */
public class BInarySearch {
    public int search(int[] nums, int target) {
        int start=0;
        int end =nums.length-1;
        int mid = (start+end)/2;
        while(mid > 0 )
        {
            if(nums[mid] == target)
                return mid;
            if(nums[mid] >target)
            {
                end =mid;
            }
            else if (nums[mid] < target)
            {
                start=mid;
            }
            mid = (start+end)/2;
        }
        return -1;

    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,3,5,7,8,9,11};
        System.out.println(new BInarySearch().search(nums,11));
    }


}
