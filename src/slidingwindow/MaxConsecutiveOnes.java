package slidingwindow;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[]nums = new int[]{1,1,1,1,1,2,2,3,1,1,1,1,1,1};

        System.out.println(max1s(nums));
    }

    public static int max1s(int nums[])
    {
        int left=0;
        int max=0;
        for(int right=0;right<nums.length;right++)
        {
            if(nums[right]==1)
            {
                int len = right-left+1; //7-4+1
                max=Math.max(max,len);
            }
            else {
                left=right+1;
            }
        }

        return max;

    }
}
