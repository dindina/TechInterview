package twopointers;


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
        for(int i = 0; i < squaredArray.length; i++) {
            System.out.print(squaredArray[i] + " ");
        }
    }

    private static int[] sortedSquares(final int[] array) {

        int left=0;
        int right = array.length-1;
        int maxpointer = array.length-1;
        int [] result = new int[array.length];

        while(left <= right)
        {
            int rightSquare = array[right]*array[right];
            int leftSquare = array[left]*array[left];

            if(rightSquare > leftSquare)
            {
                result[maxpointer--] = rightSquare;
                right--;
            }
            else
            {
                result[maxpointer--] = leftSquare;
                left++;
            }
        }
        return result;

    }

}
