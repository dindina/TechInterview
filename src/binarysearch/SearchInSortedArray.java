package binarysearch;

public class SearchInSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{12,10,1,2,4,5,};
        System.out.println(sortedSearch(nums,12));
        System.out.println(sortedSearch(nums,10));
        System.out.println(sortedSearch(nums,1));
        System.out.println(sortedSearch(nums,5));

    }

    public static int sortedSearch(int[]nums , int target)
    {
        int low = 0;
        int high = nums.length-1;

        while(low<=high)
        {
            int mid = low+ (high-low)/2;

            if(nums[mid]==target)
            {
                return mid;
            }
            //identify which half is sorted
            if(nums[low] <= nums[mid]){
                // check if the target exist in this half
                if(nums[low]<=target && target <=nums[mid]){
                    high=mid-1;
                }
                else {
                    low=mid+1;
                }
            }else {
                if(nums[mid] <=target && target <=nums[high])
                {
                    low=mid+1;
                }
                else {
                    high=mid-1;
                }
            }

        }
        return -1;
    }

}
