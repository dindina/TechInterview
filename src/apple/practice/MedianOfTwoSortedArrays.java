package apple.practice;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int [] merged = new int[nums1.length+ nums1.length];
        int p1=0;
        int p2=0;
        int index=0;

        while( p1 < nums1.length && p2 < nums2.length)
        {
            if(nums1[p1] <= nums2[p2])
            {
                merged[index++] = nums1[p1];
                p1++;
            }
            else
            {
                merged[index++] = nums2[p2];
                p2++;
            }
        }

        while(p1 < nums1.length)
        {
            merged[index++] = nums1[p1++];
        }

        while(p2 < nums2.length)
        {
            merged[index++] = nums2[p2++];
        }


        //int [] nums1 = new int[] {1,2,4};
        double res =0.0;
        if(merged.length%2 == 0){
            int mid = merged.length/2;
            res = (double)(merged[mid]+merged[mid-1])/2;
        }
        else{
            res = merged[merged.length/2];}

        return res;
    }

    public static void main(String[] args) {
        int [] nums1 = new int[] {1,2};
        int [] nums2 = new int[] {3,4};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1,nums2));

    }
}
