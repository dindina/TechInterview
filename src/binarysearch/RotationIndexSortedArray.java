package binarysearch;

public class RotationIndexSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{10,12,1,2,4};

        System.out.println(index(nums));
        System.out.println(findLowest(nums));

    }

    public static int findLowest(int [] nums)
    {
        int low =0;
        int high= nums.length-1;
        while(low <=high)
        {
            int mid = low + (high-low)/2;

            if(nums[mid]>nums[mid+1])
            {
                return nums[mid+1];
            }
            if(nums[mid] < nums[low])
            {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return nums[0];
    }

    public static int index(int[]nums)
    {
        int low =0;
        int high = nums.length-1;

        while(low<=high)
        {
            int mid = low + (high-low)/2;

            if(nums[mid]>nums[mid+1])
            {
                return mid+1;
            }

            if(nums[mid] < nums[low])
            {
                high=mid-1;
            }
            else {
                low=mid+1;
            }

        }
        return 0;
    }
}
