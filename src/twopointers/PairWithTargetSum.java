package twopointers;


/*
Problem Statement#
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

Example 1:

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 */
public class PairWithTargetSum {

    public static void main(String[] args) {
        int [] array = new int[] { 1,2,3,4,6};
        int target = 7;
        int[] result = search(array,target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] search(int[] arr, int targetSum) {


        int leftPointer=0;
        int rightPointer=arr.length-1;

        while(leftPointer < rightPointer)
        {
            int sum = arr[leftPointer] + arr[rightPointer];

            if(sum ==targetSum)
            {
                return new int[]{leftPointer,rightPointer};
            }
            else if(sum > targetSum)
            {
                rightPointer--;
            }
            else
            {
                leftPointer++;
            }
        }

        return new int[] { -1, -1 };
    }
}
