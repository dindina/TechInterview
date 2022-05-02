package binarysearch;
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */
public class SearchForARange {


    public static void main(String[] args) {
        int [] nums = new int[]{5,7,7,8,8,10};
        int[] result = new SearchForARange().find(nums,8);
        System.out.println("ans " + result[0]);
        System.out.println("ans " + result[1]);
    }

    private int[] find(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if (nums == null || nums.length == 0) {
            return result;
        }

        if (nums.length == 1 && target == nums[0]) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }

        int left = 0;
        int right = nums.length - 1;


        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] ==target || nums[mid+1] ==target )
            {
                result[0]=mid;
                result[1]=mid+1;

                return result;
            }
            if(nums[mid] < target)
                left=mid+1;
            else
                right=mid-1;

        }
        return result;
    }
}
