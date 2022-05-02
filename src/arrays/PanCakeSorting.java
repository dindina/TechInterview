package arrays;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/pancake-sorting/
Given an array of integers arr, sort the array by performing a series of pancake flips.

In one pancake flip we do the following steps:

Choose an integer k where 1 <= k <= arr.length.
Reverse the sub-array arr[0...k-1] (0-indexed).
For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.

Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.
 Example 1:

Input: arr = [3,2,4,1]
Output: [4,2,4,3]
Explanation:
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: arr = [3, 2, 4, 1]
After 1st flip (k = 4): arr = [1, 4, 2, 3]
After 2nd flip (k = 2): arr = [4, 1, 2, 3]
After 3rd flip (k = 4): arr = [3, 2, 1, 4]
After 4th flip (k = 3): arr = [1, 2, 3, 4], which is sorted.
Example 2:

Input: arr = [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip
 */
public class PanCakeSorting {

    public static void print(int[] nums)
    {
        //System.out.println("starting");
        for(int i : nums)
        {
            System.out.print(i + ",");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2,1};
        print(nums);
        System.out.println(new PanCakeSorting().pancakeSort(nums));
        System.out.println("final");
        print(nums);
    }
    public List<Integer> pancakeSort(int[] nums) {

        List<Integer> result = new ArrayList<>();
        int largest = nums.length;
        //System.out.println("largest " + largest);
        for(int i=0; i< nums.length;i++)
        {
            //find the index of largest value
            int largestindex=0;
            for(int k=0; k< nums.length;k++)
            {
                if(nums[k]==largest)
                    largestindex=k;
            }
            flip(nums,largestindex);
            flip(nums,largest-1);
            result.add(largestindex+1);
            result.add(largest--);
            //largest--;
        }
        //print(nums);
        return result;
    }

    public static void flip(int[] nums, int k)
    {
        System.out.println("flipping with k " + k);
        int i=0;
        while(i<k)
        {
            int temp = nums[k];
            nums[k]=nums[i];
            nums[i]=temp;
            i++;
            k--;
        }
    }
}
