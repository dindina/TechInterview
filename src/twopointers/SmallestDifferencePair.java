package twopointers;

import java.util.Arrays;


/*
Given two non-empty arrays of integers, find the pair of values (one value from each array) with the smallest (non-negative) difference.

Example

Input: [1, 3, 15, 11, 2], [23, 127, 235, 19, 8]

Output: [11, 8]; this pair has the smallest difference.
 */
public class SmallestDifferencePair {

    public static void main(String[] args) {

        int[] a1 = new int[] {-1, 5, 10, 20, 28, 3};
        int[] a2 = new int[] {26, 134, 135, 15, 17};

        int[] pair = findSmallestDifferencePair(a1, a2);
        System.out.println(pair);
        System.out.println(pair[0] + " " + pair[1]);

    }

    private static int[] findSmallestDifferencePair(final int[] a1, final int[] a2) {

        Arrays.sort(a1);
        Arrays.sort(a2);
        int [] returnArray = new int[2];

        int pointer1=0;
        int pointer2=0;
        int smallestDif = Integer.MAX_VALUE;

        while(pointer1 < a1.length && pointer2 < a2.length)
        {
            int difference = Math.abs(a1[pointer1]-a2[pointer2]);
            if(difference < smallestDif) {
                smallestDif = difference;
                System.out.println(smallestDif);
                // set the return array
                returnArray[0] = a1[pointer1];
                returnArray[1] = a2[pointer2];
            }

            if(a1[pointer1] < a2[pointer2])
            {
                pointer1++;
            }
            else
            {
                pointer2++;
            }

        }
        return  returnArray;
    }

}
