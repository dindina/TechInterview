package arrays;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] nums = new int[] {1,0,-2,-3,4,4,-5,-9};
        System.out.println(new MaximumProductSubArray().maxproduct(nums));

    }

    public int maxproduct(int [] nums)
    {
        int max=Integer.MIN_VALUE;
        int prefix=1;
        int suffix=1;
        int n = nums.length;
        for(int i=0; i<n;i++)
        {
            if(prefix==0)  prefix=1;
            if(suffix==0)  suffix=1;
            prefix*=nums[i]; // foward
            suffix*=nums[n-i-1]; // backward
            max = Math.max(max, Math.max(prefix,suffix));
        }

        return max;

    }
}

