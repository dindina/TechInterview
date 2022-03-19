package apple.practice;

public class SearchInARotatedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2};
        //int[] nums = new int[]{0, 1, 2};

        int rotationIndex = findRotationIndex(nums);
        System.out.println("rotationIndex " + rotationIndex);
        int target = 3;
        System.out.println("index "  + searchInRotatedArray(nums,target));
    }

    public static int searchInRotatedArray(int []nums, int target)
    {
        int rotationindex = findRotationIndex(nums);

        if(nums[rotationindex] == target)
            return rotationindex;

        if(rotationindex ==0) // search from the left
        {
            return binary_search(nums,target,0,nums.length-1);
        }
        if( target >= nums[0])
        {
            return binary_search(nums,target,0,rotationindex);
        }
        else
            return binary_search(nums,target,rotationindex,nums.length-1);

    }

    public static int binary_search(int [] nums, int target , int left , int right)
    {
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target) // 12345
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return -1;
    }

    public static int findRotationIndex(int [] nums)
    {
        if(nums[0] <= nums[nums.length-1]) return 0;
        int left=0;
        int right= nums.length-1;
        while(left<=right)
        {
            int mid = left + (right-left)/2; //2 + (3-2)/2 = 2
            if(nums[mid] > nums[mid+1])
            {
                return mid+1;
            }
            if(nums[mid] < nums[left])
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

}
