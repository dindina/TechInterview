package binarysearch;

public class BinarySearchTemplates {

    public static void main(String[] args) {
        int [] nums = new int[]{1,3,4,6,17,28,99};

        /*System.out.println(template1(nums,9));
        System.out.println(template1(nums,1));
        System.out.println(template1(nums,6));*/

        //System.out.println(template2(nums,99));

        System.out.println(template3(nums,99));


    }

    public static int template3(int[] nums , int target)
    {
        int left=0;
        int right= nums.length-1;
        while(left+1 < right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid]<target)
                left=mid;
            else
                right=mid;
        }
        System.out.println("after loop left " + left);
        System.out.println("after loop right " + right);
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;

    }

    public static int template2(int [] nums, int target)
    {
        int left =0;
        int right = nums.length-1;
        while(left<right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] ==target)
                return mid;
            if(nums[mid] < target)
            {
                left = mid+1;
            }
            else
            {
                right=mid;
            }
        }
        System.out.println("after loop " + left);
        if(nums[left] == target)
            return left;
        return -1;
    }

    public static int template1(int [] nums , int target)
    {
        int left=0;
        int right=nums.length-1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;

            if(nums[mid] == target)
            {
                return mid;
            }

            if(nums[mid] < target)
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }
        return -1;
    }
}
