package slidingwindow;

import java.util.ArrayList;
import java.util.List;


/*
Given an array of integers a, and a positive integer k, find the first negative integer for each and every window (contiguous subarray) of size k. If a window does not contain a negative integer, then print 0 for that window.

Example 1

Input: a[] = {-5, 1, 2, -6, 9}, k = 2
Output : -5 0 -6 -6

Explanation: First negative integer in every window of size 2
{-5, 1} = -5
{1, 2} = 0 (does not contain a negative integer)
{2, -6} = -6
{-6, 9} = -6
 */
public class FirstNegativeNumber {

    public static void main(String[] args) {

        int a[] = new int[]{5, -1, 2, -6, 9};
        int size = 2;
        System.out.println(firstNegativeNumber(a,size));
    }

    public static List<Integer> firstNegativeNumber(int [] array , int windowSize)
    {
        List<Integer> result = new ArrayList<>();

        int windowStart=0;
        for(int windowEnd=0; windowEnd < array.length ; windowEnd++)
        {
            int currentValue = array[windowEnd];

            while(currentValue >0 && windowEnd-windowStart+1 < windowSize)
            {
                currentValue = array[windowStart++];
            }
            if(currentValue <0)
                result.add(currentValue);
            else
                result.add(0);

        }

        return result;

    }
}
