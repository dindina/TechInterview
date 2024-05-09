package practice;

public class MaxSumSubArrayWithSizeK {

    public static void main(String[] args) {
        int nums[] = new int[]{1115,51,6111,7,911};
        int size = 2 ;
        System.out.println(slidingWindow(nums ,size));

    }

    public static int slidingWindow(int [] nums , int size)
    {
        int left=0;
        int max=0;
        int windowsum=0;

        for(int right=0; right < nums.length ; right++)
        {
            windowsum+=nums[right];
            if(right-left+1==size) // reached window
            {
                max = Math.max(max,windowsum);
                windowsum-=nums[left++];
            }
        }
        return max;
    }


}
