package binarysearch;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5,6,1,2,3,4};
        //int[] nums = new int[]{0, 1, 2};

        int rotationIndex = findRotationIndex(nums);
        System.out.println("rotationIndex " + rotationIndex);
        System.out.println("index "  + searchInRotatedArray(nums,4));
    }

    static int searchInRotatedArray(int[] nums , int target)
    {
        if(nums ==null || nums.length ==0)
            return -1;

        int rotation_index = findRotationIndex(nums);
        if(nums[rotation_index] == target)
            return rotation_index;

        if(rotation_index ==0)
        {
            int index = binary_search(nums,0,nums.length-1,target);
            return index;
        }
        // below case is for rotated
        if( target <  nums[0]) // search on the right
        {
            int index = binary_search(nums,rotation_index,nums.length-1,target);
            return index;
        }
        else // search on the left
        {
            int index = binary_search(nums,0,rotation_index,target);
            return index;
        }


    }

    private static int binary_search(int [] nums ,int left, int right , int target) {

        while(left <=right)
        {
            int mid = left+ (right-left)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            if( nums[mid] > target)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        return -1;
    }

    private static int findRotationIndex(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if(nums[left] <= nums[right]) // if it is already sorted
            return 0;
        while(left<=right)
        {
            int mid = left + (right-left)/2;

            if(nums[mid] > nums[mid+1]) // rotation point
            {
                return mid+1;
            }
            if(nums[mid] < nums[left])
            {
                right = mid-1;
            }
            else
                left = mid+1;
        }
        return 0;

    }
}
