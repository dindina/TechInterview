package twopointers;


import arrays.ArrayUtil;

import java.util.Arrays;

/*
Problem Statement
Given an array of numbers sorted in increasing order, return a new array containing squares of all the numbers of the input array sorted in increasing order.

Example 1:

Input: a[] = [-5, -2, -1, 0, 4, 6]
Output: [0, 1, 4, 16, 25, 36]
Explanation: After squaring, the array becomes [25, 4, 1, 0, 16, 36].
After sorting, it becomes [0, 1, 4, 16, 25, 36].
 */
public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int a[] = new int[]{-5, -2, -1, 0, 4, 6};

        int []squaredArray = sortedSquares(a);
        ArrayUtil.printArray(squaredArray);
        System.out.println("--------");
        int []squaredArray1 = sortedSquares1(a);
        ArrayUtil.printArray(squaredArray1);
    }

    private static int[] sortedSquares1(final int[] nums) {

        int [] result = new int[nums.length];
        int left=0;
        int right= nums.length-1;
        //int index =nums.length-1;
        //while(left<=right)
        for(int index= nums.length-1 ; index>=0 ; index--)
        {
            if(Math.abs(nums[left]) > Math.abs(nums[right]))
            {
                result[index]= nums[left]*nums[left];
                left++;
            }
            else
            {
                result[index]= nums[right]*nums[right];
                right--;
            }
        }
        //Arrays.sort(result);
        return result;

    }
    private static int[] sortedSquares(final int[] nums) {

        int left = 0;
        int right= nums.length-1;
        int[] result = new int[nums.length];

        for(int i= nums.length-1 ; i>=0 ; i--)
        {
            if(Math.abs(nums[left]) > Math.abs(nums[right]))
            {
                result[i] = nums[left]*nums[left];
                left++;
            }
            else
            {
                result[i] = nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }



}
