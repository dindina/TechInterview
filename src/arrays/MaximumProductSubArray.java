package arrays;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] nums = new int[] {1,-2,-3,4};

    }

    public int maxproduct(int [] nums)
    {
        int result =nums[0];
        int max_so_far=nums[0];
        int min_so_far=nums[0];
        for(int i=1; i<nums.length;i++)
        {
            int prev= max_so_far;
            max_so_far= Math.max(Math.max(nums[i], nums[i]*max_so_far), nums[i]*min_so_far);
            min_so_far= Math.max(Math.max(nums[i], nums[i]*prev), nums[i]*min_so_far);
            result=Math.max(result,max_so_far);
        }

        return result;

    }
}
