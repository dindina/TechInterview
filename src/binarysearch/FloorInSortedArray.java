package binarysearch;
/*
https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%253BbatchId=154&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-a-sorted-array

Given a sorted array arr[] of size N without duplicates, and given a value x. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x. Find the index of K(0-based indexing).

Example 1:

Input:
N = 7, x = 0
arr[] = {1,2,8,10,11,12,19}
Output: -1
Explanation: No element less
than 0 is found. So output
is "-1".
 */
public class FloorInSortedArray {

    public static void main(String[] args) {
        int [] nums = new int[]{1,4,5,7,8,9};

        System.out.println(floor(nums,0));

    }
    public static int floor(int[] nums , int num)
    {
        int result= nums.length;

        int low = 0;
        int high = nums.length-1;

        while(low<=high)
        {
            //int mid = low + (high-low)/2;
            int mid = (low + high)/2;

            if(nums[mid] <=num) // search left
            {
                result=mid;
                low=mid+1;
            }
            else { // search right

                high=mid-1;
            }
        }

        return result;
    }

}
