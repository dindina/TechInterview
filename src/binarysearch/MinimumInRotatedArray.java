package binarysearch;

public class MinimumInRotatedArray {
    public static void main(String[] args) {
        int [] nums = new int[]{4,5,1,2,3};

        System.out.println(findMinimum(nums));
    }

    private static int findMinimum(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int left=0;
        int right = nums.length-1;
        if(nums[0] < nums[right])
            return nums[0];
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            //System.out.println("mid " + mid);
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            if(nums[mid] < nums[left])
            {
                right= mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        return nums[0];
    }
}
