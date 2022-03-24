package arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,3,-4};
        System.out.println(MaxSubArray.maxsub(nums));

    }
    public static int maxsub(int[] nums)
    {
        int max =nums[0];
        int curr = nums[0];
        for(int i=1 ; i< nums.length;i++)
        {
            curr += nums[i];
            curr = Math.max(curr,nums[i]);
            max= Math.max(curr,max);
        }
        return max;
    }


}
