package binarysearch;

public class FindIndexOfRotation {
    public static void main(String[] args) {
        int [] nums = new int[] {4,5,1,2,3};
        System.out.println("final " + findIndex(nums));
    }

    private static int findIndex(int[] nums) {

        int left=0 ;
        int right = nums.length-1;
        if (nums[0] < nums[right])
            return 0;
        while(left <=right)
        {
            int mid = (left + right)/2;
            System.out.println("mid " + mid);
            if(nums[mid] > nums[mid+1]) {
                return mid+1;
            }
            if(nums[mid] >= nums[left])
            {
                left = mid+1;
            }
            else
                right = mid-1;
        }

        return 0;

    }
}
