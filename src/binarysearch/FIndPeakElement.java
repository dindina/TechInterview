package binarysearch;

/*
A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index

 */
public class FIndPeakElement {

    public int findPeakElement(int[] nums) {
        int left =0;
        int right = nums.length-1;

            while(left < right)
            {
                int mid = (left + right)/2;
                // 2,4,5,6,7 bad =4
                if(nums[mid] > nums[mid+1])
                {
                    right =mid;
                }
                else
                {
                    left = mid+1;
                }

            }
            return left;


    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,5,4,2,4};
        System.out.println(new FIndPeakElement().findPeakElement(nums));
    }


}
