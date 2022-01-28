package arrays;

public class MinimumInRotatedArray {

    public static int minimum(int[] nums) {

        int begin = 0;
        int end = nums.length-1;

        if(nums.length ==1 )
            return nums[0];

        if(nums[begin] < nums[end])
            return nums[begin];

        while(begin <= end)
        {
            int mid = begin + (end-begin) /2;
            if(mid>0 && nums[mid] < nums[mid-1])
                return nums[mid];

            else if(nums[mid] >= nums[begin] && nums[mid] > nums[end])
                begin = mid+1;
            else
                end = mid-1;

    }
        return -1;

    }

    public static void main(String[] args) {
        int[] prices = new int[] { 2,3,4,5,1};
        System.out.println(new MinimumInRotatedArray().minimum(prices));
    }

}
