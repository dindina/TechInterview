package apple.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i : nums1)
        {
            set1.add(i);
        }
        for(int i : nums2)
        {
            set2.add(i);
        }

        set1.retainAll(set2);
        System.out.println(set1);

        int [] array = new int[set1.size()];
        int index=0;
        for(Integer i : set1)
        {
            array[index++] = i;
        }

        return array;
    }

    public static void main(String[] args) {
        int [] nums1 = new int[] {4,9,5};
        int [] nums2 = new int[] {9,4,9,8,4};

        int[] intersection = new IntersectionOfTwoArrays().intersection(nums1,nums2);


    }
}
