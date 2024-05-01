package arrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1,4,5,6,7,8,9};
        int[] nums2 = new int[] { 0,2,6,7,8,9};

        int[] nums3 = intersection(nums1,nums2);
        //ArrayUtil.printArray(nums3);

    }

    public static int[] intersection(int[] nums1, int[]nums2)
    {
        List<Integer> intersections = new ArrayList<>();
        int l1= nums1.length;
        int l2= nums2.length;
        int i=0;
        int j=0;
        while(i<l1 && j<l2)
        {
            if(nums1[i] < nums2[j])
            {
                i++;
            }
            else if( nums2[j] < nums1[i])
            {
                j++;
            }
            else if(nums1[i]==nums2[j]) {
                intersections.add(nums1[i]);
                i++;
                j++;
            }
        }
        System.out.println(intersections);

        return null;
    }


}
