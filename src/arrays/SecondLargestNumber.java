package arrays;

public class SecondLargestNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{11,3,5,5,66,18};
        int largest=nums[0];
        int secondLargest  =-1;

        for(int i=0; i<nums.length ;i++)
        {
            if(nums[i] > largest)
            {
                secondLargest=largest;
                largest=nums[i];
            }
            else if( nums[i] >secondLargest && nums[i] <largest)
            {
                secondLargest=nums[i];
            }

        }

        System.out.println(largest);
        System.out.println(secondLargest);
    }
}
