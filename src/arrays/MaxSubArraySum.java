package arrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        //int[] nums = new int[]{-2,-3,4,-1,-2,1,5,-3}; // max is 7 from 4,-1,-2,1,5
        int[] nums = new int[]{-2,-3,-4,-1,-2};

        // logic to add the sum when the number is > 0
        int max = Integer.MIN_VALUE;
        int sum =0;
        for(int i=0; i< nums.length ; i++)
        {
            sum += nums[i];
            if(sum > 0)
            {
                System.out.println(sum);
                if(sum > max)
                    max = sum;

            }
            else {
                sum=0;;
            }
        }
        if(max <0)
            max=0;
        System.out.println("max" + max);
    }
}
